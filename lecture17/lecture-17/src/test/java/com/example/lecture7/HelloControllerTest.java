package com.example.lecture7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class HelloControllerTest {

    @Mock
    HelloController helloController= new HelloController();

    @BeforeEach
    void setUp() {
        System.out.println("Hello Before Each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Hello After Each");
    }

    @Test
    void hello() {
        HelloService helloService = mock (HelloService.class);

        helloController.setHelloService(helloService);


        when(helloService.hello()).thenReturn("Service");
        assertEquals(helloController.hello(), "Service");

        when(helloService.hello()).thenReturn("");
        assertEquals(helloController.hello(), "");

        when(helloService.hello()).thenReturn(null);
        assertEquals("123", helloController.hello());
    }

    @Disabled
    @Test
    void hello2(){
        System.out.println("Hello2");
    }
}