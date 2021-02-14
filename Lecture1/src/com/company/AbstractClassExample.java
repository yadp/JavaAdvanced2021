package com.company;

public abstract class AbstractClassExample implements TestInterface{

    abstract void abstractMethod();

    @Override
    public void testMethod() {
        System.out.println("testMethod");
    }
}
