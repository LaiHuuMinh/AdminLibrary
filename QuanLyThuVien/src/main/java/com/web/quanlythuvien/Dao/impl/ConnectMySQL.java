package com.web.quanlythuvien.Dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {

    public Connection getConnection(){

        String url = "jdbc:mysql://localhost:3306/thuvien";
        String username = "minh";
        String password = "123456789minh";


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
