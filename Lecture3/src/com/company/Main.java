package com.company;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    volatile int a=5;



    public static void main(String[] args) {
	// write your code here

      /*  final String string1="test1";
        final String string2="test2";


        Thread thread1= new Thread() {
            public void run(){
                synchronized (string1){
                    System.out.println("Thread 1 locked string 1");
                    //string1
                    try {
                        Thread.sleep(100);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (string2){
                        System.out.println("Thread1 locked string2");
                    }
                }
            }
        };

        Thread thread2=new Thread(){
            public  void run(){
                synchronized (string2){
                    System.out.println("Thread 2 locked string 2");
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    synchronized (string1){
                        System.out.println("Thread2 locked string1");
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
        */




        ExecutorService executor = Executors.newFixedThreadPool(4);
        Counter counter = new Counter();

        Future<Counter> future = executor.submit(new CounterThread(counter),counter);
       /* while (!future.isDone()) {
            System.out.println("Counter thread is not done");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        try {
            Counter counter1= future.get();
            System.out.println(counter1.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Future<String> future1 =executor.submit(new CallableTest());

        try {
            System.out.println(future1.get(100L,TimeUnit.MILLISECONDS));
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        List<CallableTest> list = new ArrayList<>();
        list.add(new CallableTest());
        list.add(new CallableTest());

        try {
            List<Future<String>> list2= executor.invokeAll(list);

            System.out.println(list2.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
