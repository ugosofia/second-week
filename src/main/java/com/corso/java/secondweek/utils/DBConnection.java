package com.corso.java.secondweek.utils;
import java.io.IOException;
import java.sql.*;

public class DBConnection {

    private static ReadProperties readProperties;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    private static LOG L = LOG.getInstance();

    /**
     * make a connection to db and return a statement
     * example: Statement statement = DBConnection.connect();
     *
     * @return
     * @throws SQLException
     */
    public static Statement connect() throws SQLException {
        try {
            if (statement == null) {
                readProperties = new ReadProperties();
                readProperties.read("application.properties");
                Class.forName(DBConstant.DB_MYSQL_URL).newInstance();
                connection = DriverManager.getConnection(DBConstant.DB_USER,DBConstant.DB_PASSWORD,DBConstant.DB_URL);//
                statement = connection.createStatement();
            } else {
                L.debug("You have invoked more times DBConnection.connect();");
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            L.err("SQLException: " + ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close();
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


    public ReadProperties getReadProperties() {
        return readProperties;
    }

    public void setReadProperties(ReadProperties readProperties) {
        this.readProperties = readProperties;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection connection) {
        DBConnection.connection = connection;
    }

    public static Statement getStatement() {
        return statement;
    }

    public static void setStatement(Statement statement) {
        DBConnection.statement = statement;
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }

    public static void setResultSet(ResultSet resultSet) {
        DBConnection.resultSet = resultSet;
    }

    public static PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public static void setPreparedStatement(PreparedStatement preparedStatement) {
        DBConnection.preparedStatement = preparedStatement;
    }

    public static LOG getL() {
        return L;
    }

    public static void setL(LOG l) {
        L = l;
    }
}

