package com.corso.java.secondweek.multithread;

import static com.corso.java.secondweek.utils.LOG.L;


public class NumberPrinterAsRunnable implements Runnable {
    int min;
    int max;

    public NumberPrinterAsRunnable(int min, int max){
        this.max = max;
        this.min = max;
    }

    public void run() {
        for (int i = min; i < max; i++) {
            System.out.println(String.valueOf(i));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadNumberPrinter tnp = new ThreadNumberPrinter(4,6);
        Thread currentThread = Thread.currentThread();
        currentThread.setName("current-thread");
        currentThread.setPriority(1);
        currentThread.run();
        Thread.sleep(1000);

        Thread thread = new Thread(tnp);
        thread.setName("nostro-thread");
        tnp.start();
        L.info("Done!");


        tnp.start();
        tnp.join();

        //L.info("Done!");
        System.out.println("done!");
    }
}

