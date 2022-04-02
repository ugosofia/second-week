package com.corso.java.secondweek.dbthread;

import com.corso.java.secondweek.utils.ConnectDB;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcreate implements Runnable{

    @Override
    public void run() {
        try {
            this.createDB();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createDB() throws IOException, SQLException, ClassNotFoundException {

        Statement statement = (Statement) ConnectDB.connect();

        statement.executeUpdate("CREATE TABLE `EXAMPLE`.`anagrafe` (\n" +
                "  `id` INT NOT NULL,\n" +
                "  `nome` VARCHAR(45) NOT NULL,\n" +
                "  `cognome` VARCHAR(45) NOT NULL,\n" +
                "  `età` INT NOT NULL,\n" +
                "  `città` VARCHAR(45) NOT NULL,\n" +
                "  `provincia` VARCHAR(2) NOT NULL,\n" +
                "  `cap` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`));");

        try {
            statement.close();
        } catch (SQLException e) {
            e.getMessage();
        }






    }
}
