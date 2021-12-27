package org.yasynskyi.myshop.Service;

import org.yasynskyi.myshop.dao.ProductDao;
import org.yasynskyi.myshop.entity.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDao productDao;

    public ProductService(ProductDao productDao){
        this.productDao = productDao;
    }

    public List<Product> findAll() throws SQLException {
        List<Product> products = productDao.findAll();
        return products;
    }
}
