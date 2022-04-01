package com.corso.java.secondweek.Athletes;

import com.corso.java.secondweek.utils.ConnectDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    private final static String CREATE_DB =
            "CREATE TABLE athletes ("
                    + "code INTEGER NOT NULL PRIMARY KEY,"
                    + "name VARCHAR(20), country VARCHAR(20),"
                    + "birth_date DATE , height DOUBLE)";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            con = ConnectDB.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Statement s = con.createStatement()) {
                s.executeUpdate(CREATE_DB);
            }
    }

}
