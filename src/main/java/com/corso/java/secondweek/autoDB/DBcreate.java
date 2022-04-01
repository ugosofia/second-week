package com.corso.java.secondweek.autoDB;


import com.corso.java.secondweek.utils.Logger;
import com.corso.java.secondweek.utils.ReadProperties;

import java.io.IOException;
import java.sql.*;

public class DBcreate implements Runnable{

    private Connection conn;
    private Statement statement;
    private ReadProperties rp = new ReadProperties();
    static Logger L = Logger.getInstance();

    public void run()  {
        try {
            conn = this.connect();
        } catch (IOException e) {
            e.getMessage();
        }
        try {
            String sql = "CREATE TABLE IF NOT EXISTS `db`.`auto` (" +
                    "  `idAuto` INT NOT NULL AUTO_INCREMENT," +
                    "  `marchio` VARCHAR(45) NOT NULL," +
                    " `nazione` VARCHAR(20) NOT NULL, " +
                    " `fatturato` INT NOT NULL, " +
                    " `dipendenti` INT NOT NULL, " +
                    "  PRIMARY KEY (`idAuto`));";


            statement = conn.createStatement();
            statement.executeUpdate(sql);
            L.info("La tabella è stata creata");


        } catch (
                SQLException e) {
            L.info("La tabella non è stata creata!!!");
            e.getMessage();
        } finally {
            try {
                this.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Connection connect() throws IOException {
        Connection conn = null;
        //rp.read();
        try {
            Class.forName(rp.getProperties().getProperty("db.driverUrl")).newInstance();
            conn = DriverManager.getConnection(rp.getProperties().getProperty("db.url"), rp.getProperties().getProperty("db.username"), rp.getProperties().getProperty("db.password"));
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return conn;

    }

    private void close() throws SQLException {
        try {
            if (statement != null) statement.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        try {
            if (conn != null) conn.close();
        } catch (SQLException se){
            se.printStackTrace();
        }

    }


}