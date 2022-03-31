package com.corso.java.secondweek.EmployeesDBThread;

import com.corso.java.secondweek.utils.DBConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import static com.corso.java.secondweek.utils.DBConnection.getPreparedStatement;
import static com.corso.java.secondweek.utils.DBConnection.getStatement;

public class CRUDTableEmployees extends EmployeesAbstract {

    Scanner in = new Scanner(System.in);
    private String query;
    private EmployeesAbstract em;
    private PreparedStatement pS;
    int id;
    String name, lastname;

    public CRUDTableEmployees() throws SQLException {
        pS = (PreparedStatement) connect();
    }


    @Override
    void insert() throws SQLException, IOException {

        query= readProp("application.properties", "insert_sql");


        int nInsert;
        try {
            System.out.print("Quanti inserimenti vuoi effettuare?: ");
            nInsert = in.nextInt();
            for (int i = 0; i < nInsert; i++) {
                System.out.print("\nInserisci id: ");
                id = in.nextInt();
                System.out.print("\nInserisci nome: ");
                name = in.next();
                System.out.print("\nInserisci cognome: ");
                lastname = in.next();


                pS.setInt(1, id);
                pS.setString(2, name);
                pS.setString(3, lastname);


            }


        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
    @Override
    void create() throws IOException, SQLException {
        EmployeesAbstract em = new CRUDTableEmployees();
        em.createTable();
    }

    @Override
    void update() {

    }
    @Override
    void delete() {

    }

    @Override
    public void run() {

    }
}
