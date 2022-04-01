package com.corso.java.secondweek.EmployeesDBThread;

import com.corso.java.secondweek.utils.ConnectDB;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;



public class CRUDTableEmployees {
    private final static String SELECT_DB = "SELECT * FROM employees WHERE id = ?";
    private final static String INSERT_DB = "INSERT INTO employees (name, surname) values (?, ?)";
    private final static String SELECT_DB1 = "SELECT * FROM employees ORDER BY surname, name";

    Scanner in = new Scanner(System.in);
    private String query;
    private PreparedStatement pS;
    int id;
    String name, lastname;


    /**
     * @return
     * @throws SQLException
     * @throws IOException
     */
    boolean insert() throws SQLException, IOException {
        try (Connection con = ConnectDB.connect()) {
            try (PreparedStatement ps =
                         con.prepareStatement(INSERT_DB)) {
                ps.setString(1, name);
                ps.setString(2, lastname);
                return ps.execute();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Optional<Employees> first_select(Optional<Integer> limit) throws SQLException, ClassNotFoundException, IOException {
        try (Connection con = ConnectDB.connect()) {
            PreparedStatement pstmt = con.prepareStatement(SELECT_DB);
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                //Riga con l'id passato non trovata
                if (!rs.next()) {
                    return Optional.empty();
                }

                return Optional.of(
                        Employees.builder()
                                .id(id).name(rs.getString("name")).lastname(rs.getString("surname"))
                                .build());
            }


        }
    }
}
