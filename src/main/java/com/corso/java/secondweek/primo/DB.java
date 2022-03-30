package com.corso.java.secondweek.primo;

import com.corso.java.secondweek.primo.Costanti;

import java.sql.*;

public class DB {

    public static void main(String[] args) throws SQLException {

        Connection conn = null;
        ResultSet rS = null;
        Statement statement = null;

        try {

            Class.forName(Costanti.mysql_url).newInstance();
            conn = DriverManager.getConnection(Costanti.url, Costanti.usr, Costanti.psw);
            statement = conn.createStatement();
            rS = statement.executeQuery(Costanti.insert_db);
            rS = statement.executeQuery(Costanti.update_db);

            ResultSetMetaData md = rS.getMetaData();

            while (rS.next()) {
                for (int i = 1; i <=  md.getColumnCount(); i++) {
                    System.out.println(rS.getString(i));
                }
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        } finally {
            close(rS, statement, conn);
        }

    }
    public static void close(ResultSet rS, Statement statement, Connection conn) throws SQLException {
        if(rS != null)
            rS.close();
        if(statement != null)
        statement.close();
        if(conn != null)
        conn.close();
    }
}

