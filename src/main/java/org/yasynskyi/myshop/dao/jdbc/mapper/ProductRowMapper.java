package org.yasynskyi.myshop.dao.jdbc.mapper;

import org.yasynskyi.myshop.entity.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ProductRowMapper {
    public Product mapRow(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        BigDecimal price = resultSet.getBigDecimal("price");
        int number = resultSet.getInt("number");
        String description = resultSet.getString("description");
        Timestamp date = resultSet.getTimestamp("date");

        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setNumber(number);
        product.setDescription(description);
        product.setDate(date.toLocalDateTime());

        return product;
    }
}
