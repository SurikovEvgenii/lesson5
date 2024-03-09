package com.surikov.lesson5;

import com.surikov.lesson5.entity.Order;
import com.surikov.lesson5.entity.ProductOrder;
import com.surikov.lesson5.service.OrderService;
import com.surikov.lesson5.service.ProductOrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name="cartServlet",value = "/cartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OrderService orderService;
        ProductOrderService productOrderService;
        Order order = new Order() ;
        ProductOrder productOrder = new ProductOrder();
        Date date = new Date();

        order.setNumber_order(Integer.parseInt(req.getRequestedSessionId()));
        productOrder.setProduct_id(Integer.parseInt(req.getParameter("productId")));
        productOrder.setOrder_id(order.getId());
        productOrder.setCount(Integer.parseInt(req.getParameter("count")));






    }
}
