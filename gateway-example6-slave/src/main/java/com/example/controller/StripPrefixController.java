package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fatal
 * @date 2020/7/11 0011 9:48
 */
@RestController
public class StripPrefixController {

    @GetMapping("/red")
    public String red() {
        return "/red";
    }

}
