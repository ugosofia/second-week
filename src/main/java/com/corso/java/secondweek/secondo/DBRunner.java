package com.corso.java.secondweek.secondo;

import com.corso.java.secondweek.secondo.DBAccess;

import java.sql.SQLException;

public class DBRunner {

    public static void main(String[] args) throws SQLException {

        DBAccess dbAccess = new DBAccess();
        dbAccess.readDatabase();
    }
}