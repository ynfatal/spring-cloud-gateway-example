package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 RewritePath GatewayFilter
 * @author Fatal
 * @date 2020/7/10 0010 5:30
 */
@RestController
@RequestMapping("/foo")
public class RewritePathController {

    @GetMapping("/blue")
    public String blue() {
        return "blue";
    }

}
