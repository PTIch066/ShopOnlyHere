package org.yasynskyi.myshop.dao.jdbc;

import org.yasynskyi.myshop.dao.ProductDao;
import org.yasynskyi.myshop.dao.jdbc.mapper.ProductRowMapper;
import org.yasynskyi.myshop.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    private static final ProductRowMapper PRODUCT_ROW_MAPPER = new ProductRowMapper();
    private static final String FIND_ALL_SQL = "SELECT ID, name, price, number, description, date FROM products";

    @Override
    public List<Product> findAll() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<Product> products = new ArrayList<>();

            while (resultSet.next()) {
                products.add(PRODUCT_ROW_MAPPER.mapRow(resultSet));
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String url, user, password;

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyShop", "postgres", "Copperfield");
    }
}