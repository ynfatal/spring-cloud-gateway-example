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
public class AddRequestHeaderController {

    @GetMapping("/red/{segment}")
    public HeaderVO red(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, String> map = new HashMap<>();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String values = request.getHeader(name);
            map.put(name, values);
        }
        return new HeaderVO().setHeaders(map.entrySet().stream()
            .sorted(Entry.comparingByKey())
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> newValue, LinkedHashMap::new)));
    }
}
