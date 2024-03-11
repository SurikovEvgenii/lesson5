package com.surikov.lesson5.service;

import com.surikov.lesson5.DbManager;
import com.surikov.lesson5.entity.Cart;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartService {
    public List<Cart> getCart(int orderNumber) {

        List<Cart> cartList = new ArrayList<>();
        String query = "SELECT products.name, products.description, products.price, products_order.count, products_order.product_id, products_order.order_id " +
                "FROM products JOIN products_order ON products.id = products_order.product_id " +
                "JOIN orders ON orders.id = products_order.order_id  WHERE number_order ="+orderNumber;

        try (Connection connection = DbManager.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String description = resultSet.getString(2);
                int count = resultSet.getInt(3);
                int price = resultSet.getInt(4);
                int productId = resultSet.getInt(5);
                int orderId = resultSet.getInt(6);
                cartList.add(new Cart(name, description, price, count, productId, orderId));
            }

            return cartList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteCart(int productId, int orderId) {

        String query = "DELETE FROM products_order WHERE product_id=" + productId +" AND order_id=" + orderId;

        try (Connection connection = DbManager.createConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cart> getProductCart(int productIdReq) {

        String query = "SELECT orders.number_order FROM orders JOIN products_order ON orders.id = products_order.order_id  WHERE product_id =" + productIdReq;
        List<Cart> cartList = new ArrayList<>();

        try (Connection connection = DbManager.createConnection();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int numberOrder = resultSet.getInt(1);
                cartList.add(new Cart(numberOrder));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cartList;
    }
}
