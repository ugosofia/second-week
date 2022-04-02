package com.corso.java.secondweek.Athletes;

import com.corso.java.secondweek.utils.ConnectDB;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class AthletesAccess implements BaseRepository<Integer>{

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Scanner in = new Scanner(System.in);
    private static final String SELECT_ATHLETE = "SELECT * FROM employees WHERE id = ?";
    private static final String INSERT_ATHLETE = "INSERT INTO employees (code, name, nation, country, birth_date, height) values (?, ?, ?, ?, ?, ?)";


    @Override
    public boolean persist() {
        boolean b = false;
        try {
            conn = ConnectDB.connect();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        try {
            ps = conn.prepareStatement(INSERT_ATHLETE);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            ps.setInt(1, 10);
            ps.setString(2, "es_name");
            ps.setString(3, "es_country");
            ps.setString(4, "17/05/1980");
            ps.setDouble(5, 185.5);
        } catch (SQLException se) {
            se.printStackTrace();

            try {
                 b =  ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return b;
    }

    @Override
    public boolean delete( Athletes athlete) throws SQLException {

        if (athlete == null) {
            throw new IllegalArgumentException(
                    "L'atleta passato come parametro è null");
        }

        try {
            conn = ConnectDB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        ps = conn.prepareStatement(SELECT_ATHLETE);

                ps.setInt(1, athlete.getCode());
                rs = ps.executeQuery() ;

                    if (!rs.next()) {
                        close();
                        return false;
                    }
                    rs.deleteRow();
                    close();
                    return true;
    }


    @Override
    public List findbyprimarykey(Integer code) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            conn = ConnectDB.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = conn.prepareStatement(SELECT_ATHLETE);

        ps.setObject(1, code);
        ResultSet rs = ps.executeQuery();

        return List.of(
                    Athletes.builder()
                            .code((Integer) code).name(rs.getString("name"))
                            .country(rs.getString("country"))
                            .birth_date(rs.getDate("birth_date"))
                            .height(rs.getDouble("height"))
                            .build());
        }



    public void close() throws SQLException {
        if (conn!= null) {
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

        if (rs!= null)
            rs.close();
    }


}

