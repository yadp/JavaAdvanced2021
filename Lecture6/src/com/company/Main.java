package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] arr= new int[9];


        Connection connection = null;
        try {
             connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/world","world","dadw"
             );

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from country LIMIT 100;");

            System.out.println(resultSet.getMetaData().getColumnCount());


            while (resultSet.next()){
                System.out.println(resultSet.getString(3));
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
