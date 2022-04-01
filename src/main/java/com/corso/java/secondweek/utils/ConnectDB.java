package com.corso.java.secondweek.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "Basket151097";
    public static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";
    public static final String DB_MYSQL_URL = "com.mysql.cj.jdbc.Driver";

    public static Connection connect() throws SQLException, SQLException {
        return DriverManager.getConnection(
                ConnectDB.DB_URL, ConnectDB.DB_USER, ConnectDB.DB_PASSWORD);
    }
}
