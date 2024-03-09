package com.surikov.lesson5;

import com.surikov.lesson5.entity.Product;
import com.surikov.lesson5.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "addProductServlet", value = "/add-product-servlet")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        String name = req.getParameter("Name");
        String description = req.getParameter("Description");
        int price = Integer.parseInt(req.getParameter("Price"));
        productService.insert(new Product(name,description,price));
    }
}
