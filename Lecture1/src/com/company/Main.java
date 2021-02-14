package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = new int[5];
        System.out.println(arr.length);

        String a1 = new String("Test");
        String b1 = new String("Test2");

        if( a1.equals( b1) ){

        }

        Test test= new Test(5);
        test.testMethod();
        TestB testB=new TestB(6);
        testB.testMethod();
        testB.testC();

        Test.testStatic();

        Singleton s1= Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        s1.setA(5);
        System.out.println(s2.getA());

        System.out.println(s1.equals(s2));




    }
}
