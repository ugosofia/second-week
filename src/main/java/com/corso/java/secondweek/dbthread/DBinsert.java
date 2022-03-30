package com.corso.java.secondweek.dbthread;

import com.corso.java.secondweek.utils.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class DBinsert implements Runnable {
    @Override
    public void run() {

    }

    public void insertDB() throws SQLException {
        Statement statement = DBConnection.connect();
        statement.execute("");
    }
}
