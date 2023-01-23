package com.example.comapy.services;

import com.example.comapy.configs.DataBaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBaseService extends DataBaseConfig {
    Connection connection;
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + host + "/" + database;

        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(connectionString, login, password);

        return connection;
    }
}