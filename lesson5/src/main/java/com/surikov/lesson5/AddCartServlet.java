package com.surikov.lesson5;

import com.surikov.lesson5.entity.Cart;
import com.surikov.lesson5.entity.Order;
import com.surikov.lesson5.entity.ProductOrder;
import com.surikov.lesson5.service.CartService;
import com.surikov.lesson5.service.OrderService;
import com.surikov.lesson5.service.ProductOrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name="cartServlet",value = "/cartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        List<Cart> productCartList;
        CartService cartService = new CartService();
        productCartList = cartService.getCart(1);
        for(Cart cart: productCartList){
            out.println("<br>" + cart.getName())
            ;
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OrderService orderService = new OrderService();
        ProductOrderService productOrderService = new ProductOrderService();

        Order order = new Order() ;
        ProductOrder productOrder = new ProductOrder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        order.setNumberOrder(1);
        order.setDate(formatter.format(LocalDateTime.now()));

        productOrder.setProductId(Integer.parseInt(req.getParameter("productId")));
        productOrder.setOrderId(orderService.getId());
        productOrder.setCount(Integer.parseInt(req.getParameter("count")));


        orderService.insert(order,productOrder);


        resp.sendRedirect("/cart.jsp");
    }
}
