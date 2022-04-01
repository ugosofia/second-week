package com.corso.java.secondweek.OrdiniDB;

import com.corso.java.secondweek.utils.ConnectDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonOperations extends Thread implements Operations<Person> {
    PreparedStatement ps = null;
    ResultSet rs;
    Connection conn;

    private final static String CREATE_TABLE_PERSON = "CREATE TABLE person (id INTEGER NOT NULL PRIMARY KEY, name VARCHAR(20) NOT NULL, lastname VARCHAR(20) NOT NULL, age INTEGER NOT NULL)";
    private static final String INSERT_PERSON = "INSERT INTO person (id, name, lastname, age ) values (?, ?, ?, ?)";
    private static final String SELECT_PERSON = "SELECT * FROM person WHERE id = ?";


    @Override
    public void createTable() {
        try {
            conn = ConnectDB.connect();
            conn.prepareStatement(CREATE_TABLE_PERSON);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean insert() {
        boolean b = false;
        try {
            conn = ConnectDB.connect();
            ps = conn.prepareStatement(INSERT_PERSON);
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        try {
            ps.setInt(1, 1);
            ps.setString(2, "Ugo");
            ps.setString(3, "Sofia");
            ps.setInt(4, 50);

            b =  ps.execute();
        } catch (SQLException se) {
            se.printStackTrace();
        }

        return b;
    }

    @Override
    public boolean delete(Person object) {
        return false;
    }

    @Override
    public List<Person> findbyprimarykey(int personid) {
            List<Person> persone = new ArrayList<>();

            try {
                conn = ConnectDB.connect();

                ps = conn.prepareStatement(SELECT_PERSON);

                ps.setObject(1, personid);
                rs = ps.executeQuery();

            } catch (IOException | SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                persone = List.of(
                        Person.builder()
                                .id(rs.getInt("id"))
                                .name(rs.getString("name"))
                                .lastname(rs.getString("lastname"))
                                .age(rs.getInt("age"))
                                .build());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return persone;
        }



    @Override
    public List<Person> findbyforeignkey(int id) {
        return null;
    }

    public void close(){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!= null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs!= null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
