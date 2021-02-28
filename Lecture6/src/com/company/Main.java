package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Connection connection = null;
        try {
             connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world","root","1234"
             );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select name from country;");

            System.out.println(resultSet);

            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
    }
}
