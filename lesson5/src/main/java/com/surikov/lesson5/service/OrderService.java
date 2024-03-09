package com.surikov.lesson5.service;

import com.surikov.lesson5.DbManager;
import com.surikov.lesson5.entity.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private static final String SQL_INSERT="INSERT INTO orders(number_order, date) values(?,?)";
    public void insert(Order order){
        try (Connection connection = DbManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setInt(1, order.getNumber_order());
            statement.setDate(2, (Date)order.getDate());
            statement.executeUpdate();

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
                Date date = resultSet.getDate(3);
                orders.add(new Order(id,numberOrder,date));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orders;
    }
}
