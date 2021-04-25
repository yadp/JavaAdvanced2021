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







}
