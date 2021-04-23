package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {



        final Customer c=new Customer();
        new Thread(){
            public void run(){c.withdraw(15000);}
        }.start();
        new Thread(){
            public void run(){c.deposit(10000);}
        }.start();




        // write your code here
        ImplementRunnable implementRunnable = new ImplementRunnable();
        Thread thread =  new Thread(implementRunnable);
        thread.start();
        thread.interrupt();

        ExecutorService executorService = Executors.newFixedThreadPool(3);




    }
}
