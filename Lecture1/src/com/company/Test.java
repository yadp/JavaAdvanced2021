package com.company;

import java.util.List;

public class Test extends AbstractClassExample implements TestInterface,TestInterfaceExtend {

    public final static double PI= 3.14;
    public final static long EXAMPLE_LONG= 10l;


    private int a;
    private List<String> exampleList;

    public Test() {
    }

    public Test(int a) {

        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public List<String> getExampleList() {
        return exampleList;
    }

    public static void testStatic(){

    }

    public void addToList(String text){
        exampleList.add(text);
    }

    @Override
    public void testMethod() {

    }

    public void testMethod(int a){

    }

    @Override
    void abstractMethod() {

    }



}
