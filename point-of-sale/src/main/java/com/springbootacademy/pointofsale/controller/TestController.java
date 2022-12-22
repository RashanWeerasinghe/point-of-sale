package com.springbootacademy.pointofsale.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping("/text")
    public String getMyText(){
        String myText="this is my first springboot app";
        System.out.println(myText);
        return myText;
    }

    @GetMapping("/amount")
    public Integer  getMyAmount(){
        Integer n=10000;
        System.out.println("Your Amount is = "+n);
        return n;
    }
}
