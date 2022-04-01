package com.corso.java.secondweek.utils;
import java.io.IOException;
import java.sql.*;

public class DBConnection {

    private static ReadProperties readProperties;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    private static Logger L = Logger.getInstance();

    public static Statement connect() throws SQLException {
        try {
            if(statement == null) {
                readProperties = new ReadProperties();
                Class.forName(ConnectDB.DB_MYSQL_URL).newInstance();
                connection = ConnectDB.connect();
                statement = connection.createStatement();
            }else{
                L.debug("You have invoked more times DBConnection.connect();");
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException | IOException ex) {
            L.err("SQLException: " + ex.getMessage());
        }

        return statement;
    }

    public static void close() throws SQLException {
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

