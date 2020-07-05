package com.example.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试 AddRequestHeader GatewayFilter 带 URI变量的。
 * @author Fatal
 * @date 2020/7/6 0006 5:37
 */
@RestController
public class AddRequestHeaderController {

    @GetMapping("/red/{segment}")
    public ResponseEntity<String> red(@PathVariable("segment") String segment, HttpServletRequest request) {
        System.out.println(request.getHeader("X-Request-Red"));
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity("http://httpbin.org:80/get", String.class);
    }
}
