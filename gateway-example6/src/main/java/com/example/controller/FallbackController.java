package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fatal
 * @date 2020/7/7 13:03
 */
@RestController
public class FallbackController {

    @GetMapping("/incaseoffailureusethis")
    public String inCaseOfFailureUseThis() {
        return "fallback";
    }

}
