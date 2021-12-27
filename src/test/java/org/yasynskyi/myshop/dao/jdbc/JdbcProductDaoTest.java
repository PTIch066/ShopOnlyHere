package org.yasynskyi.myshop.dao.jdbc;

import org.junit.jupiter.api.Test;
import org.yasynskyi.myshop.entity.Product;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JdbcProductDaoTest {
    @Test
    public void testFindAllReturnCorrectData() throws SQLException {
        JdbcProductDao jdbcProductDao = new JdbcProductDao();
        List<Product> products = jdbcProductDao.findAll();
        for (Product product : products) {
            assertNotEquals(0, product.getId());
            assertNotNull(product.getId());
            assertNotNull(product.getName());
            assertNotNull(product.getPrice());
            assertNotNull(product.getNumber());
            assertNotNull(product.getDescription());
            assertNotNull(product.getDate());
        }
    }

}