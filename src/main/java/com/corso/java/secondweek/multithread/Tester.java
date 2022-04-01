package com.corso.java.secondweek.multithread;


import static com.corso.java.secondweek.utils.Logger.L;

public class Tester {

    public static void main(String[] args) throws InterruptedException {
        ThreadNumberPrinter tnp = new ThreadNumberPrinter(4,6);
        tnp.start();
        tnp.join();
        L.info("Done!");
        System.out.println("done!");


        Thread thread = new Thread(tnp);
        tnp.start();
        L.info("Done!");
        System.out.println("done!");
    }
}
