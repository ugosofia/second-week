package com.corso.java.secondweek.dbthread;

import com.corso.java.secondweek.utils.ConnectDB;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class DBinsert implements Runnable {
    @Override
    public void run() {

    }

    public void insertDB() throws SQLException, IOException, ClassNotFoundException {
        Statement statement = (Statement) ConnectDB.connect();
        statement.execute("");
    }
}
