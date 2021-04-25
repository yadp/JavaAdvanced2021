package com.example.lecture20;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    //@RequestMapping(value="/orders/{id}", method= RequestMethod.GET)
    @GetMapping("/orders/{id}")
    public String showOrder(@PathVariable("id") long id) throws IllegalArgumentException {
        if ( id != 1) {
            throw new IllegalArgumentException("No orders");
        } else {

            return "order 1";

        }//throw new OrderNotFound();

    }

    @ResponseStatus(value= HttpStatus.CONFLICT,
           reason="Data integrity violation")  // 409
    @ExceptionHandler(IllegalArgumentException.class)
    public void conflict(Exception ex) {
        ex.printStackTrace();
        System.out.println("Test if this is executed");
        // Nothing to do
    }





}
