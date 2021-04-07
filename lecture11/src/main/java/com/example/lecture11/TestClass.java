package com.example.lecture11;

import org.springframework.beans.factory.annotation.Autowired;

public class TestClass {

    @Autowired
    private Animal animal;

    public void testMethod(){
        System.out.println(this.animal);
    }
}
