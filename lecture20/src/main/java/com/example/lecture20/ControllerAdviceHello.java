package com.example.lecture20;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHello extends ResponseEntityExceptionHandler {


    @ExceptionHandler(OrderNotFound.class)
    public ResponseEntity<Object> conflict(RuntimeException ex, WebRequest request) {

        // Nothing to do

        return handleExceptionInternal(ex, "TestBody",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }


    //@ResponseStatus(value = HttpStatus.CONFLICT,
    //       reason = "Data integrity violation")  // 409
    @ExceptionHandler({IllegalArgumentException.class, Exception.class})
    public ResponseEntity<Object> conflict(Exception ex, WebRequest request) {
        ex.printStackTrace();
        System.out.println("Test if this is executeddasd");
        // Nothing to do
        return handleExceptionInternal(ex, "TestBody",
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}