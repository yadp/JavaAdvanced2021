package com.company;

public class ImplementRunnable implements Runnable{

    private  int count = 0;
    public ImplementRunnable(){

    }

    public  int getCount() {
        return count;
    }

    public  void setCount(int count) {
        this.count = count;
    }

    public synchronized void addCount(){
        setCount(getCount()+1);
    }

    @Override
    public void run() {

        for (int i = 0; i < 10000; i++) {

            synchronized (this) {
                setCount(getCount() + 1);
            }

            System.out.println(getCount());
        }


    }
}
