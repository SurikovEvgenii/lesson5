package com.surikov.top;

import com.surikov.lesson5.DbManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class MyTest {

    @Test
    void testBatchCommand(){
        try {
            Connection connection = DbManager.createConnection();
            Statement statement = connection.createStatement();
            statement.addBatch("INSERT INTO phonebook values (2, 'name2')");
            statement.addBatch("INSERT INTO phonebook values (3, 'name3')");
            int[] ints = statement.executeBatch();

            Assertions.assertTrue(ints.length == 2);
            assertEquals(3, ints.length);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testBatchPreparedCommand(){
        try (Connection connection = DbManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "update phonebook set name=? where id=?")){
            preparedStatement.setString(1, "newName");
            preparedStatement.setInt(2, 2);
            preparedStatement.addBatch();
            preparedStatement.setString(1, "newName2");
            preparedStatement.setInt(2, 3);
            preparedStatement.addBatch();
            int[] ints = preparedStatement.executeBatch();

            assertEquals(2, ints.length);


        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Test
    void getGeneratedKeys() {
        String query = "insert into phonebook values (12, 'generatedkeys2')";
        try (Connection connection = DbManager.createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            //generatedKeys.getInt(1);

            assertEquals(12, generatedKeys.getInt(1));


        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

        @Test
        void testTransaction(){
            String query1 ="";
            String query2 = "";
            try(Connection connection = DbManager.createConnection();
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2)){

                preparedStatement1.executeUpdate();
                preparedStatement2.executeUpdate();

            }catch (SQLException e){
             throw new RuntimeException();
            }
        }
    }
