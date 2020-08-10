package com.java.manager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    static DbConfig config = null;
    static Connection con = null;

    public static DbConfig getSqlConfig() {
        config.dbDriver = "com.mysql.jdbc.Driver";
        config.dbUrl = "jdbc:mysql://localhost/servletdb";
        config.dbUserName = "root";
        config.dbPassword = "";
        return config;
    }

    public static Connection getConnection() {
        try {
            Class.forName(config.dbDriver);
            con = DriverManager.getConnection(getSqlConfig().dbUrl, getSqlConfig().dbUserName, getSqlConfig().dbPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void rollback(Connection connection){
        if (connection!=null){
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void commit(Connection connection){
        if (connection!=null){
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection connection){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
