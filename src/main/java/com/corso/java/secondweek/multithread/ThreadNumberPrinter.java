package com.corso.java.secondweek.multithread;

public class ThreadNumberPrinter extends Thread {
    int min;
    int max;

    public ThreadNumberPrinter(int min, int max){
        this.max = max;
        this.min = min;
    }

    public void run() {
        for (int i = min; i < max; i++) {
            System.out.println((i));
        }
    }



}
