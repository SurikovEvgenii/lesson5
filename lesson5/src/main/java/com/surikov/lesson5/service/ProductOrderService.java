package com.surikov.lesson5.service;

import com.surikov.lesson5.DbManager;
import com.surikov.lesson5.entity.Cart;
import com.surikov.lesson5.entity.ProductOrder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductOrderService {
    private static final String SQL_INSERT="INSERT INTO products_order(product_id, order_id, count) values(?,?,?)";
    public void insert(ProductOrder productOrder){
        try (Connection connection = DbManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setInt(1, productOrder.getProductId());
            statement.setInt(2, productOrder.getOrderId());
            statement.setInt(3, productOrder.getCount());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<ProductOrder> getAll(){

        //staticTest();
        List<ProductOrder> productOrders = new ArrayList<>();

        try (Connection connection = DbManager.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products_order");

            while (resultSet.next()) {
                int productId = resultSet.getInt(1);
                int orderId = resultSet.getInt(2);
                int count = resultSet.getInt(3);
                productOrders.add(new ProductOrder(productId,orderId,count));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productOrders;
    }

}
