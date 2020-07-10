package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fatal
 * @date 2020/7/11 0011 6:57
 */
@RestController
public class SetPathController {

    @GetMapping("/blue")
    public String blue() {
        return "/blue";
    }

}
