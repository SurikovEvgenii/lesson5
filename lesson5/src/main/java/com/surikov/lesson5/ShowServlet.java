package com.surikov.lesson5;

import com.surikov.lesson5.entity.Cart;
import com.surikov.lesson5.entity.Product;
import com.surikov.lesson5.service.CartService;
import com.surikov.lesson5.service.OrderService;
import com.surikov.lesson5.service.ProductService;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.RequestDispatcher;
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
        List<Cart> cartList;
        ProductService productService = new ProductService();
        CartService cartService = new CartService();

        String productIdStr = req.getParameter("productId");

        if(productIdStr == null) {
            productList = productService.getAll();
            for(Product product: productList){
                out.println("<br>" + product.getName());
            }
        } else  {
            cartList = cartService.getProductCart(Integer.parseInt(productIdStr));
            for(Cart cart: cartList){
                out.println("<br>" + cart.getNumberOrder());
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cart.jsp").forward(req,resp);
    }
}
