package com.corso.java.secondweek.autoDB;

import com.corso.java.secondweek.utils.DBConnection;
import com.corso.java.secondweek.utils.LOG;
import com.corso.java.secondweek.utils.ReadProperties;

import java.io.IOException;
import java.sql.*;


public class DBSelect implements Runnable{

            static LOG L = LOG.getInstance();
            private Connection conn = null;
            private ReadProperties rP = new ReadProperties();
            private PreparedStatement pS;


            public void run() {

                try {
                    conn = this.connect();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    pS = conn.prepareStatement("SELECT marchio, fatturato FROM auto ORDER BY fatturato DESC;");


                } catch (SQLException ex) {
                    ex.printStackTrace();

                } finally {
                    try {
                        this.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }

            private void close() throws SQLException {
                if (pS != null) pS.close();
                if (conn != null) conn.close();
            }

            public Connection connect() throws IOException {
                Connection conn = null;
                //rP.read();
                try {
                    Class.forName(rP.getProperties().getProperty("db.driverUrl")).newInstance();
                    conn = DriverManager.getConnection(rP.getProperties().getProperty("db.url"), rP.getProperties().getProperty("db.username"), rP.getProperties().getProperty("db.password"));
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                return conn;
            }
        }




