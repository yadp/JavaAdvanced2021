package com.company;

public class Factorial implements Runnable{

    private int n;
     public Factorial(int n){
         this.n=n;
     }
    @Override
    public void run() {
         Long result=1L;
        for (int i = 1; i <= n; i++) {
            result=result*i;
        }
        System.out.println("Factorial is " +
                ""+ result);
    }
}
