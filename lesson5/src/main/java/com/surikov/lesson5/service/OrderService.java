package com.surikov.lesson5.service;

import com.surikov.lesson5.DbManager;
import com.surikov.lesson5.entity.Order;
import com.surikov.lesson5.entity.ProductOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private static final String SQL_INSERT1="INSERT INTO orders(number_order, date) values(?,?)";
    private static final String SQL_INSERT2="INSERT INTO products_order(product_id, order_id, count) values(?,?,?)";
    public void insert(Order order, ProductOrder productOrder){
        try (Connection connection = DbManager.createConnection()) {
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(SQL_INSERT1);
            statement.setInt(1, order.getNumberOrder());
            statement.setString(2, order.getDate());
            statement.addBatch();

            statement = connection.prepareStatement(SQL_INSERT2);
            statement.setInt(1, productOrder.getProductId());
            statement.setInt(2, productOrder.getOrderId());
            statement.setInt(3, productOrder.getCount());
            statement.addBatch();

            statement.executeBatch();

            connection.setAutoCommit(true);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Order> getAll(){

        //staticTest();
        List<Order> orders = new ArrayList<>();

        try (Connection connection = DbManager.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int numberOrder = resultSet.getInt(2);
                String date = resultSet.getString(3);
                orders.add(new Order(id,numberOrder,date));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }

    public int getId(){

        //staticTest();
        List<Order> orders = new ArrayList<>();

        try (Connection connection = DbManager.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM orders");

            resultSet.next();
            return resultSet.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
