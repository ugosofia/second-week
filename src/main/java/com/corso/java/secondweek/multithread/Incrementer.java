package com.corso.java.secondweek.multithread;

public class Incrementer implements Runnable{
    private final int[] data;

    public Incrementer(int[] data) {
        this.data = data;
    }


    @Override
    public void run() {
        for (int i = 0; i < data.length; i++) {
            data[i] += i;
        }

    }
}
