package com.ra.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectPractice {
    // driver
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // url
    private static final String URL = "jdbc:mysql://localhost:3306";
    // user
    private static final String USER = "root";
    // pass
    private static final String PASS = "anhduc1101";

    // openConnect
    public static Connection openConnection() {
        //1. tao connection tu lop Connection
        Connection connection = null;
        try {
            //2. tu lop Class, cham den pthuc forname(), truyen DRIVER
            Class.forName(DRIVER);
            //3. gan connection = DriverManager, cham den pthuc getConnection, truyen URL,USER,PASS
            connection= DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //4. return ve connection
        return connection;
    }
    // closeConnect
    public static void closeConnection(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
