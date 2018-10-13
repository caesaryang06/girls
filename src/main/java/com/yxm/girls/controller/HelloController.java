package com.yxm.girls.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String contents;

    @GetMapping("/hello")
    public String say(){

        return "i like girl with "+contents;
    }

}
