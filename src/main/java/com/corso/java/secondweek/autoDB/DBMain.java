package com.corso.java.secondweek.autoDB;

import com.corso.java.secondweek.utils.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class DBMain implements Runnable{
    public static void main(String[] args) throws InterruptedException{

        try {

            Thread createT = new Thread(new DBcreate());
           // Thread selectT = new Thread(new DBSelect());
            //Thread printT = new Thread(new DBPrint());

            createT.start();
            createT.join();
            createT.setPriority(1);

          /**  selectT.start();
            selectT.join();
            selectT.setPriority(2);

            // PRINT TABLE ROWS
            printT.start();
            printT.join();
            printT.setPriority(3);
*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }
}
