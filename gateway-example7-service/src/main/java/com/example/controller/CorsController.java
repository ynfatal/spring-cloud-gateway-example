package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试跨域问题
 * @author Fatal
 * @date 2020/7/12 0012 13:39
 */
@RestController
public class CorsController {

    @GetMapping("/cors")
    public String get() {
        return "/cors";
    }
}
