package com.corso.java.secondweek.autoDB;

import com.corso.java.secondweek.utils.DBConnection;
import com.corso.java.secondweek.utils.LOG;
import com.corso.java.secondweek.utils.ReadProperties;

import java.sql.*;

public class DBcreate implements Runnable{

    Statement statement = null;
    PreparedStatement preparedStatement = null;
    Connection connection = null;


    public DBcreate() throws SQLException {
        DBConnection.connect();

        String sql = "CREATE TABLE `EXAMPLE`.`auto` (`id` INT NOT NULL,`marchio` VARCHAR(45) NOT NULL,`nazione` VARCHAR(45) NOT NULL,`fatturato` INT NOT NULL,`dipendenti` INT NOT NULL);";

        DBConnection.close();
    }

    @Override
    public void run() {
        try {
            new DBcreate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
