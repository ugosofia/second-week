package com.corso.java.secondweek.secondo;

import org.apache.log4j.Logger;

import java.sql.*;

public class DBAccess implements db<ResultSet> {


    private final Logger logger = Logger.getLogger(DBAccess.class);

    private PreparedStatement preparedStatement;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    private final String DB_DRIVER_URL = "com.mysql.cj.jdbc.Driver";
    private final String DB_PASSWORD = "Basket151097";
    private final String DB_USER = "root";
    private final String DB__URL = "jdbc:mysql://localhost/EXAMPLE";


    @Override
    public void readDatabase() throws SQLException {


        try {
            Class.forName(DB_DRIVER_URL);
            connection = DriverManager.getConnection(DB__URL, DB_USER, DB_PASSWORD);

            String sql = "CREATE TABLE `EXAMPLE`.`person` (\n" +
                    "  `idperson` INT NOT NULL,\n" +
                    "  `name` VARCHAR(45) NULL,\n" +
                    "  `lastname` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`idperson`));";

            statement = connection.createStatement();
            int a = statement.executeUpdate(sql);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws SQLException {
        if (resultSet != null)
            resultSet.close();

        if (statement != null)
            statement.close();

        if (preparedStatement != null)
            preparedStatement.close();

        if (connection != null)
            connection.close();
    }
}