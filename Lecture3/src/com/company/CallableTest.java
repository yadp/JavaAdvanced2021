package com.company;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        int n=0;
        for (int i = 0; i < 100000; i++) {
            n++;

            Thread.sleep(1000);
            System.out.println(n);
        }
        return String.valueOf(n);
    }
}
