package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here


        ImplementRunnable implementRunnable = new ImplementRunnable();
        Thread thread =  new Thread(implementRunnable);


        Thread thread2 =  new Thread(implementRunnable);



        thread2.start();
        thread.start();





           /* Factorial implementRunnable = new Factorial(20);
            Thread thread =  new Thread(implementRunnable);
            thread.start();

            Fibbonacci implementRunnable1=new Fibbonacci(20);
            Thread thread1=new Thread(implementRunnable1);
            thread1.start();

        try {
            thread.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TestMessage");*/


        //ExtendThread extendThread = new ExtendThread(10);

    }
}
