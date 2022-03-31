package com.corso.java.secondweek.EmployeesDBThread;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeesMain {

    public static void main(String[] args) throws SQLException, IOException {
        EmployeesAbstract em = new CRUDTableEmployees();
        em.create();
        em.insert();
        em.print();



    }
}
