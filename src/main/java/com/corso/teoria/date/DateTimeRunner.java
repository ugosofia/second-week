package com.corso.teoria.date;

import com.corso.java.secondweek.utils.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeRunner {

    public static void main(String[] args) throws ParseException {
        Logger L = Logger.getInstance();
        Date d = new Date();
        L.info(d.toString());

        DateFormat dateFormat = DateFormat.getDateInstance();
        L.info(dateFormat.format(d));

        DateFormat dateFormat2 = DateFormat.getDateInstance(DateFormat.FULL);
        L.info(dateFormat.format(d));

        DateFormat dateFormat3 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        L.info(dateFormat.format(d));

        DateFormat dateFormat4 = DateFormat.getDateInstance(DateFormat.LONG);
        L.info(dateFormat.format(d));

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        System.out.println( sdf.format( d.getTime() ) );

        String birthday = "25/09/1977";
        SimpleDateFormat birthdayFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdayDay = birthdayFormatter.parse(birthday);
        L.info(birthdayFormatter.format(birthdayDay));
    }
}
