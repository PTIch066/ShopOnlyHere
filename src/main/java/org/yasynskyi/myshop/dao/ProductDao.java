package org.yasynskyi.myshop.dao;

import org.yasynskyi.myshop.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> findAll() throws SQLException;
}
