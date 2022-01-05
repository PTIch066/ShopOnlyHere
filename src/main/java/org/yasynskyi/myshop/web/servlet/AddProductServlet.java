package org.yasynskyi.myshop.web.servlet;

import org.yasynskyi.myshop.Service.ProductService;
import org.yasynskyi.myshop.web.util.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddProductServlet extends HttpServlet {
        private ProductService productService;

        public AddProductServlet(ProductService productService) {
            this.productService = productService;
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PageGenerator pageGenerator = PageGenerator.instance();
        String page = pageGenerator.getPage("add_product.html");
        resp.getWriter().write(page);
    }

}
