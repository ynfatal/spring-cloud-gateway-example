package com.example.controller;

import com.example.vo.HeaderVO;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试 AddRequestHeader GatewayFilter 带 URI变量的。
 * @author Fatal
 * @date 2020/7/6 0006 5:37
 */
@RestController
public class AddRequestHeaderController extends BaseController {

    @GetMapping("/red/{segment}")
    public HeaderVO red(HttpServletRequest request) {
        return super.headers(request);
    }
}
