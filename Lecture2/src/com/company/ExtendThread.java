package com.company;

public class ExtendThread extends Thread{

    public static final int DEFAULT_COUNT=1000;
    private  int count;
    public ExtendThread(){
        this.count=DEFAULT_COUNT;
        start();
    }
    public  ExtendThread(int count){
        this.count=count;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(i);
        }
    }
}
