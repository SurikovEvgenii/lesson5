package com.surikov.lesson5;

import com.surikov.lesson5.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "deleteProductServlet", value = "/delete-product-servlet")
public class DeleteCartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CartService cartService = new CartService();
        int productId = Integer.parseInt(req.getParameter("productId"));
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        cartService.deleteCart(productId,orderId);

        resp.sendRedirect("/cart.jsp");

    }
}
