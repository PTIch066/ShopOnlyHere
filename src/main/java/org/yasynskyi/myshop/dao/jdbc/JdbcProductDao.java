package org.yasynskyi.myshop.dao.jdbc;

import org.yasynskyi.myshop.dao.ProductDao;
import org.yasynskyi.myshop.dao.jdbc.mapper.ProductRowMapper;
import org.yasynskyi.myshop.entity.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDao implements ProductDao {

    private static final ProductRowMapper PRODUCT_ROW_MAPPER = new ProductRowMapper();
    private static final String FIND_ALL_SQL = "SELECT ID, name, price, number, description, date FROM products";
    private static final String BUY_PRODUCT_SQL = "DELETE FROM products WHERE id = ?";
    private static final String EDIT_PRODUCT_SQL = "UPDATE products SET name = ?, price = ?, number = ?, description = ? WHERE id = ?";
    private static final String ADD_PRODUCT_SQL = """
            INSERT INTO products (name, price, number, description)
            VALUES(?, ?, ?, ?, ?)
            """;

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

    @Override
    public void add(Product product) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT_SQL)) {
            if (product.getPrice().compareTo(BigDecimal.ZERO) < 0) {
                throw new RuntimeException();
            }
            preparedStatement.setString(1, product.getName());
            preparedStatement.setBigDecimal(2, product.getPrice());
            preparedStatement.setInt(3, product.getNumber());
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void buyProduct(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(BUY_PRODUCT_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void editProduct(int id, String name, BigDecimal price, int number, String description) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_PRODUCT_SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setBigDecimal(2, price);
            preparedStatement.setInt(3, number);
            preparedStatement.setString(4, description);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyShop", "postgres", "password");
    }
}