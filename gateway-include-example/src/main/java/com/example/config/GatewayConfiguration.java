package com.example.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fatal
 * @date 2020/7/3 9:11
 */
@Configuration(proxyBeanMethods = false)
public class GatewayConfiguration {

    private static final String HTTP_URI = "http://httpbin.org:80";

    /**
     * 添加两个路由
     * 1. http://localhost:8080/get -> http://httpbin.org:80/get (Path Predicate)
     *  - path: 拦截请求路径带 "/get" 的请求
     *  - filter: 为该请求添加请求头 Hello:World
     *  - rui: 路由到 httpbin.org:80
     * 2. http://localhost:8080/delay/3 -> http://httpbin.org:80/delay/3 (Host Predicate)
     *  - host: 拦截请求头带 "*.hystrix.com" 的请求
     *  - filter:
     *    - hystrix: 服务降级路径为 "forward:/fallback"
     *  - rui: 路由到 httpbin.org:80
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(p -> p
                .path("/get")
                .filters(f -> f.addRequestHeader("Hello", "World"))
                .uri(HTTP_URI)
            )
            .route(p -> p
                .host("*.hystrix.com")
                .filters(f -> f
                    .hystrix(config -> config
                        .setName("mycmd")
                        .setFallbackUri("forward:/fallback")
                    )
                ).uri(HTTP_URI)
            ).build();
    }

}
