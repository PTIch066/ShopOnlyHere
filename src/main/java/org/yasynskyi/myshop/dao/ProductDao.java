package org.yasynskyi.myshop.dao;

import org.yasynskyi.myshop.entity.Product;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> findAll() throws SQLException;

    void add(Product product);

    void buyProduct(int id);

    void editProduct(int id, String name, BigDecimal price, int number, String description);
}
