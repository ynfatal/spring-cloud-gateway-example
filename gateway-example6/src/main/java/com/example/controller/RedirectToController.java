package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 RedirectTo GatewayFilter
 * @author Fatal
 * @date 2020/7/9 8:34
 */
@RestController
public class RedirectToController {

    @GetMapping("/request-to")
    public String requestTo() {
        return "Hello, Fatal!";
    }

}
