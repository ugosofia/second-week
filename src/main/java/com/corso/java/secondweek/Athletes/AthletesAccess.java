package com.corso.java.secondweek.Athletes;

import com.corso.java.secondweek.utils.ConnectDB;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class AthletesAccess implements BaseRepository<Integer>{

    Scanner in = new Scanner(System.in);
    private static final String SELECT_ATHLETE = "SELECT * FROM employees WHERE id = ?";
    private static final String INSERT_ATHLETE = "INSERT INTO employees (code, name, nation, country, birth_date, height) values (?, ?, ?, ?, ?, ?)";


    @Override
    public boolean persist() {
        Connection conn = null;
        Boolean b = false;
        try {
            conn = ConnectDB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        PreparedStatement ps =
                null;
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
            close(conn, ps, null);
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
        Connection con = null;
        try {
            con = ConnectDB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        PreparedStatement ps = con.prepareStatement(SELECT_ATHLETE);

                ps.setInt(1, athlete.getCode());
                ResultSet rs = ps.executeQuery() ;

                    if (!rs.next()) {
                        close(con, ps, rs);
                        return false;
                    }
                    rs.deleteRow();
                    close(con, ps, rs);
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



    public void close(Connection conn, Statement s, ResultSet rs) throws SQLException {
        if (conn!= null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (s!= null) {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (rs!= null)
            rs.close();
    }


}

