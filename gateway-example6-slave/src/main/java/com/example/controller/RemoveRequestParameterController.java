package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 RemoveRequestParameter
 * @implNote 为什么不把这个控制器写在 gateway-example6 里呢？因为写进去之后，会出现接口匹配问题。
 * 请求 http://localhost:8080/remove-request-parameter?name=fatal 能在 gateway-example6 找到对应的接口，就不走网关逻辑了。
 * @author Fatal
 * @date 2020/7/9 16:57
 */
@RestController
public class RemoveRequestParameterController {

    @GetMapping("remove-request-parameter")
    public String removeRequestParameter(String name) {
        return String.format("name = %s", name);
    }

}
