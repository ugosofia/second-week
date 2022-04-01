package com.corso.java.secondweek.OrdiniDB;


import com.corso.java.secondweek.utils.ConnectDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderOperations extends Thread implements Operations<Order>{

    PreparedStatement ps = null;
    ResultSet rs;
    Connection conn;

    private static final String INSERT_ORDER = "INSERT INTO order (orderID, nOrder, personID ) values (?, ?, ?)";
    private final static String CREATE_TABLE_ORDER = "CREATE TABLE order (orderID INTEGER NOT NULL PRIMARY KEY, nOrder INTEGER NOT NULL, personID INTEGER, FOREIGN KEY (personID) REFERENCES Person(id))";
    private static final String SELECT_ORDER = "SELECT * FROM order WHERE orderID = ?";
    private int id;



    @Override
    public void createTable() {
        try {
            conn = ConnectDB.connect();
            conn.prepareStatement(CREATE_TABLE_ORDER);
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public boolean insert() {
        boolean b = false;
        try {
        conn = ConnectDB.connect();
            ps = conn.prepareStatement(INSERT_ORDER);
        } catch (SQLException | ClassNotFoundException | IOException e) {
        e.printStackTrace();
        }

        try {
        ps.setInt(1, 10);
        ps.setInt(2, 100);
        ps.setInt(3, 1);
    } catch (SQLException se) {
        se.printStackTrace();

        try {
            b =  ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        return b;
}

    @Override
    public boolean delete(Order object) {
        if (object == null) {
            throw new IllegalArgumentException(
                    "L'ordine passato come parametro è null");
        }
        try {
            conn = ConnectDB.connect();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        try {
            ps = conn.prepareStatement(SELECT_ORDER);
            ps.setInt(1, 1);
            rs = ps.executeQuery() ;

            if (!rs.next()) {
                return false;
            }
            rs.deleteRow();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public List<Order> findbyprimarykey(int id) {

        List<Order> ordine = new ArrayList<>();
        try {
            conn = ConnectDB.connect();

            ps = conn.prepareStatement(SELECT_ORDER);

            ps.setObject(1, id);
            rs = ps.executeQuery();

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            ordine = List.of(
                    Order.builder()
                            .orderID(rs.getInt("orderID"))
                            .nOrder(rs.getInt("nOrder"))
                            .personID(rs.getInt("personID"))
                            .build());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordine;
    }


    @Override
    public List<Order> findbyforeignkey(int id) {
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
