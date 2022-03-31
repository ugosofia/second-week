package com.corso.java.secondweek.EmployeesDBThread;

import com.corso.java.secondweek.utils.DBConnection;
import com.corso.java.secondweek.utils.LOG;
import com.corso.java.secondweek.utils.ReadProperties;

import java.io.IOException;
import java.sql.*;

import static com.corso.java.secondweek.utils.DBConnection.getStatement;

public  abstract class EmployeesAbstract implements Runnable {
    private static ReadProperties readProperties;
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static LOG L = LOG.getInstance();


    public EmployeesAbstract() throws SQLException {

    }

    abstract void create() throws IOException, SQLException;

    abstract void update();

    abstract void insert() throws IOException, SQLException;

    abstract void delete();


    public Statement connect() throws SQLException {
       return statement = DBConnection.connect();
    }

    public String readProp(String fileName, String key) throws IOException {
        readProperties = new ReadProperties();
        readProperties.read(fileName);
        return readProperties.getProperties().getProperty(key);
    }

    public void createTable() throws IOException, SQLException {
        String sql = readProp("application.properties", "createtable");
        statement.executeUpdate(sql);
    }

    public void print() throws SQLException {
        ResultSet resultSet = getStatement().getResultSet();
        ResultSetMetaData md = resultSet.getMetaData();

        while (resultSet.next()) {
            for (int i = 1; i <= md.getColumnCount(); i++) {
                md.getColumnName(i);
                L.debug(resultSet.getString(i));
            }
        }
    }
}
