package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 学习响应式编程再研究 Mono
 * @author Fatal
 * @date 2020/7/2 0002 23:00
 */
@RestController
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello, Fatal!";
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }

}
