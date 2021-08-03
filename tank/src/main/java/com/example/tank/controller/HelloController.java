package com.example.tank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Y~chao
 * @create 2021/8/3 15:39
 */
@RestController
@RequestMapping("/api/0-0-1/")
public class HelloController {

    @GetMapping("/test")
    public String test(){
        return "success!!!";
    }
}
