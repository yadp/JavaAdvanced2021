package com.company;

public class CounterThread implements Runnable{
    public Counter counter;

    public CounterThread(Counter counter){
        this.counter=counter;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++){
                counter.incrementCount();
                System.out.println(Thread.currentThread().getName() +" - " + counter.getCount());

        }
    }
}
