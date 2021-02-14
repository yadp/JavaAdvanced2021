package com.company;

public class Fibbonacci  implements Runnable{

    private int n;
    public Fibbonacci(int n){
        this.n=n;
    }
    @Override
    public void run() {
        Long num1=0L;
        Long num2=1L;
        for (int i = 1; i <= n-2; i++) {
            Long temp = num1+ num2;
            num1=num2;
            num2=temp;
        }
        System.out.println("Fibbonacci is" +
                " "+ num2);
    }
}
