package com.example.lecture7;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private  HelloService helloService;

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/api/hello")
    public String hello(){
        if ( helloService.hello()== null){
            return "12345";
        } else {
            return helloService.hello();
        }
    }
}
