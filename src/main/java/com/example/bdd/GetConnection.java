package com.example.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class GetConnection {

    private String _connectionUrl = "jdbc:mysql://127.0.0.1:3306/superCesi_db";
    private Connection connection = null;

    public Connection GetConnection(){
        try {
            loadDataBase();
            connection = DriverManager.getConnection(_connectionUrl,"root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void loadDataBase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}