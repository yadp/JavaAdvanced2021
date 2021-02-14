package com.company;

public class Singleton {

    private static Singleton exampleSingleton;

    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(exampleSingleton == null){
            exampleSingleton = new Singleton();
        }
        return exampleSingleton;
    }
}
