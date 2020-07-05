package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Path Route Predicate
 * @author Fatal
 * @date 2020/7/5 0005 15:20
 */
@RestController
public class PathController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/red/{segment}")
    public String red(@PathVariable("segment") String segment) {
        return String.format("http://localhost:%s/red/%s", port, segment);
    }

    @GetMapping("/blue/{segment}")
    public String blue(@PathVariable("segment") String segment) {
        return String.format("http://localhost:%s/blue/%s", port, segment);
    }

}
