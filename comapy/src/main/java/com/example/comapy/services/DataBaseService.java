package com.example.comapy.services;

import com.example.comapy.configs.DataBaseConfig;
import com.example.comapy.models.Const;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public  class DataBaseService extends DataBaseConfig{

    public static Connection connection;

    public String host = "cetus.lite-host.in";
    public String login = "gntesfbu_vsuet";
    public String password = "lHgQSNNdV";
    public String database = "gntesfbu_vsuet";

    public static Connection getConnection() {

        String connectionString = "jdbc:mysql://cetus.lite-host.in/gntesfbu_vsuet";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, "gntesfbu_vsuet", "lHgQSNNdV");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }


}
