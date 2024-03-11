package com.surikov.top;

import com.surikov.lesson5.DbManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestConnection {

    @Test
    void testInsert(){
        try {
            Connection connection = DbManager.createConnection();
            Statement statement = connection.createStatement();
            String SQL_INSERT1="INSERT INTO orders(number_order, date) values('1','10-10-0000')";
            String SQL_INSERT2="INSERT INTO products_order(product_id, order_id, count) values('1','1','1')";

            statement.addBatch(SQL_INSERT1);
            statement.addBatch(SQL_INSERT2);
            int[] ints = statement.executeBatch();

            Assertions.assertTrue(ints.length == 2);
            assertEquals(2, ints.length);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testSelectFalse(){
        try {
            Connection connection = DbManager.createConnection();
            Statement statement = connection.createStatement();
            String SQL_INSERT1="INSERT INTO orders(number_order, date) values('1','10-10-0000')";
            String SQL_INSERT2="INSERT INTO products_order(product_id, order_id, count) values('2','3','1')";

            statement.addBatch(SQL_INSERT1);
            statement.addBatch(SQL_INSERT2);
            int[] ints = statement.executeBatch();

            Assertions.assertTrue(ints.length == 3);
            assertEquals(2, ints.length);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
