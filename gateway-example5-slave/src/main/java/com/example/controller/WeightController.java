package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Weight Route Predicate
 * @author Fatal
 * @date 2020/7/5 0005 21:36
 */
@RestController
public class WeightController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/weight")
    public String weight() {
        return String.format("http://localhost:%s/weight", port);
    }

}
