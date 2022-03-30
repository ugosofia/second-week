package com.corso.java.secondweek.dbthread;

import com.corso.java.secondweek.utils.DBConnection;
import com.corso.java.secondweek.utils.ReadProperties;

import java.io.IOException;
import java.sql.*;

/**
 * Implementare un database formato da tabella: ANAGRAFICA(ID, Nome, Cognome, Eta, Citta, Provincia, CAP).
 * Scrivere un programma JAVA che effettui l’inserimento dei nominativi e stampi i record della tabella a video.
 * Il programma deve utilizzare dei treah, per cui deve inserire le varie operazioni in thread differenti.
 */
public class DBThread extends Thread{

    public static void main(String[] args) throws InterruptedException {

        DBcreate create = new DBcreate();
        DBinsert insert;
        DBprint print;

        Thread createT = new Thread(create);
        //Thread insertT = new Thread(insert);
        //Thread printT = new Thread(print);

        createT.run();
        createT.join();
        createT.setPriority(1);



        }
}


