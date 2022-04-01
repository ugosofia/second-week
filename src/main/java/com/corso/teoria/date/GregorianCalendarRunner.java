package com.corso.teoria.date;
import com.corso.java.secondweek.utils.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarRunner {

    public static void main(String[] args) {


        GregorianCalendar dataAttuale = new GregorianCalendar();
        Logger L =  Logger.getInstance();
        int anno = dataAttuale.get(GregorianCalendar.YEAR);
        int mese = dataAttuale.get(GregorianCalendar.MONTH) + 1; //i mesi partono da 0
        int giorno = dataAttuale.get(GregorianCalendar.DATE);
        int ore = dataAttuale.get(GregorianCalendar.HOUR);
        int minuti = dataAttuale.get(GregorianCalendar.MINUTE);
        int secondi = dataAttuale.get(GregorianCalendar.SECOND);


        L.info(String.valueOf(anno));
        L.info(String.valueOf(mese));
        L.info(String.valueOf(ore));
        L.info(String.valueOf(minuti));
        L.info(String.valueOf(secondi));

        GregorianCalendar data1 = new GregorianCalendar(2008, 11, 18);
        GregorianCalendar data2 = new GregorianCalendar(2007, 11, 10);

        if (data1.before(data2)) {
            System.out.println("data 1 precede data 2");
        } else if (data1.after(data2)) {
            System.out.println("dati 2 precede data 1");
        } else {
            System.out.println("Le date sono uguali");
        }
    }

}