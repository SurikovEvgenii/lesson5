package com.surikov.lesson5.service;

import com.surikov.lesson5.DbManager;
import com.surikov.lesson5.entity.Cart;
import com.surikov.lesson5.entity.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    public List<Cart> getCart(int id) {

        List<Cart> cartList = new ArrayList<>();
        String query = "SELECT products.name, products.description, products.price, products_order.count FROM products JOIN products_order ON products.id = products_order.product_id JOIN orders ON orders.id = products_order.order_id  WHERE number_order ="+id;

        try (Connection connection = DbManager.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String description = resultSet.getString(2);
                int price = resultSet.getInt(3);
                int count = resultSet.getInt(4);
                cartList.add(new Cart(name, description, price, count));
            }

            return cartList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
