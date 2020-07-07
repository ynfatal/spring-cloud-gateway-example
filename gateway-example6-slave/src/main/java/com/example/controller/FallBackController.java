package com.example.controller;

import com.example.vo.HeaderVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试 The FallbackHeaders GatewayFilter Factory
 * @author Fatal
 * @date 2020/7/7 0007 22:05
 */
@RestController
public class FallBackController extends BaseController {

    @GetMapping("/fallback")
    public HeaderVO fallback(HttpServletRequest request) {
        return super.headers(request);
    }

}
