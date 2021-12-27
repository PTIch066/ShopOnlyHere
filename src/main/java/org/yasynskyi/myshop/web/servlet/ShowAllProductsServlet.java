package org.yasynskyi.myshop.web.servlet;

import org.yasynskyi.myshop.Service.ProductService;
import org.yasynskyi.myshop.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowAllProductsServlet extends HttpServlet {
    private ProductService productService;

    public ShowAllProductsServlet(ProductService productService){
        this.productService = productService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = null;
        try {
            products = productService.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String data = products.toString();
        resp.getWriter().write(data);
    }
}
