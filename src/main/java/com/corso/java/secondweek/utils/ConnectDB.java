package com.corso.java.secondweek.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "Basket151097";
    public static final String DB_URL = "jdbc:mysql://localhost/EXAMPLE";
    public static final String DB_MYSQL_URL = "com.mysql.cj.jdbc.Driver";


    public static Connection connect() throws SQLException, ClassNotFoundException, IOException {
        ReadProperties rp = new ReadProperties();
        rp.read("application.properties");

        Class.forName(rp.getProperties().getProperty("db_mysqlurl"));
        return DriverManager.getConnection(
                rp.getProperties().getProperty("db_url"),
                rp.getProperties().getProperty("db_username"),
                rp.getProperties().getProperty("db_password"));
    }
}
