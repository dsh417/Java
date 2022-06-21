package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class TestController {
    @RequestMapping("test")
    public void test(){
        System.out.println("hello world");
    }
}
