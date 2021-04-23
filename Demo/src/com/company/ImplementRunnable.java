package com.company;

public class ImplementRunnable implements Runnable{

    public ImplementRunnable(){

    }

    @Override
    public void run() {
        System.out.println("We are in a new thread");


        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            System.out.println("We are here");
            e.printStackTrace();
        }
    }
}
