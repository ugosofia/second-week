package com.corso.java.secondweek.EmployeesDBThread;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeesMain {



    public static void main(String[] args) throws SQLException, IOException {
        CRUDTableEmployees em = new CRUDTableEmployees();
        em.insert();
        //em.first_select();
        //em.print();



    }
}
