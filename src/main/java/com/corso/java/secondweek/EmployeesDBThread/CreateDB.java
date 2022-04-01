package com.corso.java.secondweek.EmployeesDBThread;

import com.corso.java.secondweek.utils.ConnectDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    private final static String CREATE_DB_DDL =
            "CREATE TABLE employees ("
                    + "id SERIAL NOT NULL PRIMARY KEY,"
                    + "name VARCHAR(255), surname VARCHAR(255))";

    public static void main(String[] args) throws SQLException {
        try (Connection con = ConnectDB.connect()) {

            try (Statement stmt = con.createStatement()) {
                //Esegue la query
                stmt.executeUpdate(CREATE_DB_DDL);
            }
        }
    }
}
