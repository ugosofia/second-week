package com.corso.java.secondweek.autoDB;

import com.corso.java.secondweek.utils.DBConnection;
import com.corso.java.secondweek.utils.DBConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain implements Runnable{
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
        Class.forName(DBConstant.DB_MYSQL_URL);
        Connection con = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_PASSWORD);
        Statement stm = con.createStatement();


        Thread createT = new Thread(new DBcreate());
        // Thread selectT = new Thread(new DBSelect());
        //Thread printT = new Thread(new DBPrint());

        createT.run();
        //createT.join();
        createT.setPriority(1);

        /**  selectT.start();
          selectT.join();
          selectT.setPriority(2);

          // PRINT TABLE ROWS
          printT.start();
          printT.join();
          printT.setPriority(3);
*/

    }

    @Override
    public void run() {

    }
}
