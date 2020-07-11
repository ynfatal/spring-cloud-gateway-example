package com.example.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

/**
 * 测试 ModifyRequestBody GatewayFilter
 * 注解 @Profile 指定该配置类在特定环境下有资格注册。
 * @author Fatal
 * @date 2020/7/11 0011 13:49
 */
@Configuration(proxyBeanMethods = false)
@Profile(value = "modify_a_request_body_route")
public class ModifyRequestBodyConfiguration {

    @Value("${test.uri}")
    private String uri;

    /**
     * 使用配置类的方式可以按照这个格式写。
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("modify_a_request_body_route", r -> r.order(-1)
                    .host("*.modifyarequestbody.org")
                    .filters(f -> f.modifyRequestBody(
                            Hello.class, Hello.class, MediaType.APPLICATION_JSON_VALUE,
                            ((serverWebExchange, body) -> {
                                return Mono.just(body != null ? new Hello().setMessage(body.getMessage().toUpperCase()) : body);
                            })))
                    .uri(uri))
                .build();
    }

    @Data
    @Accessors(chain = true)
    static class Hello {
        private String message;
    }
}
