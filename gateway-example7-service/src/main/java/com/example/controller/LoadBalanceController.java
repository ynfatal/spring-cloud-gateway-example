package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fatal
 * @date 2020/7/7 8:32
 */
@RestController
@RequestMapping("/service")
public class LoadBalanceController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/load_balance")
    public String loadBalance() {
        return String.format("Hello, Fatal! prot: %s", port);
    }

}
