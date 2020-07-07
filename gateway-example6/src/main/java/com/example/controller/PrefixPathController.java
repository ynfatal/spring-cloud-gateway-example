package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 PrefixPath GatewayFilter
 * @author Fatal
 * @date 2020/7/8 0008 5:55
 */
@RestController
@RequestMapping("/mypath")
public class PrefixPathController {

    @GetMapping("/hello")
    public String myPath() {
        return "mypath";
    }

}
