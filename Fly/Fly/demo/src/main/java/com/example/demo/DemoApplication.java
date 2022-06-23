package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @GetMapping("/hello-world")
    public String helloWrld(){
        return "hello world!!!";
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
