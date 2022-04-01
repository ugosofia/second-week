package com.corso.java.secondweek.Athletes;

import com.corso.java.secondweek.utils.ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {

    private final static String CREATE_DB =
            "CREATE TABLE athletes ("
                    + "code INTEGER NOT NULL PRIMARY KEY,"
                    + "name VARCHAR(20), country VARCHAR(20),"
                    + "birth_date DATE , height DOUBLE)";

    public static void main(String[] args) throws SQLException {
        Connection con = ConnectDB.connect();

            try (Statement s = con.createStatement()) {

                s.executeUpdate(CREATE_DB);

            }
    }
}
