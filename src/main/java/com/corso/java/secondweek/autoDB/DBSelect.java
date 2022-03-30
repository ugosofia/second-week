package com.corso.java.secondweek.autoDB;

import com.corso.java.secondweek.utils.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;


public class DBSelect implements Runnable{

        Statement statement = null;
        DBConnection connection = null;


        public DBSelect() throws SQLException {

        }

        @Override
        public void run() {
            String sql = "SELECT marchio, fatturato FROM auto ORDER BY fatturato DESC;";


                try {
                    DBConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
}

