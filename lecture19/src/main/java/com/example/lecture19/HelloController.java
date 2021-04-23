package com.example.lecture19;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value="/orders/{id}", method= RequestMethod.GET)
    public String showOrder(@PathVariable("id") long id) {


        throw new OrderNotFound();

    }

    @ResponseStatus(value= HttpStatus.CONFLICT,
            reason="Data integrity violation")  // 409
    @ExceptionHandler(OrderNotFound.class)
    public void conflict() {
        // Nothing to do
    }
}
