package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 测试 ModifyResponseBody GatewayFilter
 * @author Fatal
 * @date 2020/7/11 0011 16:06
 */
@Configuration(proxyBeanMethods = false)
@Profile(value = "modify_a_response_body_route")
public class ModifyResponseBodyConfiguration {

    @Value("${test.uri}")
    private String uri;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("modify_a_response_body_route", r -> r.order(-1)
                    .host("*.modifyaresponsebody.org")
                    .filters(f -> f.modifyResponseBody(
                        Map.class, Map.class,
                        (serverWebExchange, body) -> {
                            Map<String, String> headers = (Map) body.get("headers");
                            headers.put("Accept-Encoding", headers.get("Accept-Encoding") + ",fatal");
                            return Mono.just(body);
                        }))
                    .uri(uri))
                .build();
    }

}
