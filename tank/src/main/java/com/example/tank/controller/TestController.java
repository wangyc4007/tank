package com.example.tank.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Y~chao
 * @create 2021/8/3 15:58
 */
@RestController
@RequestMapping("/test/")
public class TestController {

    @Value("${vpe.ip:8888}")
    private String ip;
    @Value("${vpe.port:8888}")
    private String port;
    @Value("${vpe.username:8888}")
    private String username;
    @Value("${vpe.password:8888}")
    private String password;

    /**
     * 测试
     *
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(@RequestParam(value = "sleep_time", required = false) Integer sleepTime1,
                           HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(ip);
        System.out.println(port);
        System.out.println(username);
        System.out.println(password);
        return port;
    }

}
