package com.example.tank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Y~chao
 * @create 2021/8/3 15:58
 */
@RestController
@RequestMapping("/test/")
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "hello world！！！";
    }

}
