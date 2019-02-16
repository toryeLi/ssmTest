package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    public TestController(){
        System.out.println("TestController-->instance");
    }
    @RequestMapping
    public String index(){
        return  "index.jsp";
    }
}
