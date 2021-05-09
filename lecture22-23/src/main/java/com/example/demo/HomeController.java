package com.example.demo;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@Profile("dev")
public class HomeController {


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "503", description = "NotOk")
    })

    @GetMapping("/health")
    public @ResponseBody String test(@RequestParam String test){
        int a=5;
        a++;
        a++;
        //Select *
        return "Hello Yavor";
    }

    @GetMapping("/test")
    public @ResponseBody HttpEntity<Greeting> test2(){

        Greeting greeting = new Greeting("test2");
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }


    @GetMapping("/greeting")
    public @ResponseBody HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        Greeting greeting = new Greeting(name);
        greeting.add(linkTo(methodOn(HomeController.class).greeting(name)).withSelfRel());
        greeting.add(linkTo(methodOn(HomeController.class).test2()).withRel("demo"));

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
