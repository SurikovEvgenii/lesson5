package com.surikov.lesson5.service;

import com.surikov.lesson5.DbManager;
import com.surikov.lesson5.entity.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static final String SQL_INSERT="INSERT INTO products(name,description,price) values(?,?,?)";
    public void insert(Product product){
        try (Connection connection = DbManager.createConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setString(1, product.getName() );
            statement.setString(2, product.getDescription());
            statement.setInt(3,product.getPrice());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Product> getAll(){

        //staticTest();
        List<Product> products = new ArrayList<>();

        try (Connection connection = DbManager.createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String description = resultSet.getString(3);
                int price = resultSet.getInt(4);
                products.add(new Product(id,name,description,price));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }
}
