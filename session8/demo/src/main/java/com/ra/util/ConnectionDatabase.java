package com.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/session08";
    private static final String USER = "root";
    private static final String PASSWORD = "anhduc1101";

    // taoj phương thức mở kết nối
    public static Connection openConnection()  {
        Connection connection = null;
        try {
            // đăng ký Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // gan ket noi
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    // tao phuong thuc dong ket noi
    public static void closeConnection(Connection connection){
        if (connection !=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(ConnectionDatabase.openConnection());
    }
}
