package com.surikov.lesson5;

import com.surikov.lesson5.entity.Product;
import com.surikov.lesson5.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "showServlet", value = "/select-show")
public class ShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        List<Product> productList;
        ProductService productService = new ProductService();
        productList = productService.getAll();
        for(Product product: productList){
            out.println("<br>" + product.getName());
        }
    }
}
