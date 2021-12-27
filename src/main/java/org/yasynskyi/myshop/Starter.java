package org.yasynskyi.myshop;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.yasynskyi.myshop.Service.ProductService;
import org.yasynskyi.myshop.dao.jdbc.JdbcProductDao;
import org.yasynskyi.myshop.web.servlet.ShowAllProductsServlet;

public class Starter {
    public static void main(String[] args) throws Exception {
        //config

        //dao
        JdbcProductDao jdbcProductDao = new JdbcProductDao();

        //service
        ProductService productService = new ProductService(jdbcProductDao);

        //servlet
        ShowAllProductsServlet showAllProductsServlet = new ShowAllProductsServlet(productService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(showAllProductsServlet), "/");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
    }
}
