package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayExample6Application {

    public static void main(String[] args) {
        SpringApplication.run(GatewayExample6Application.class, args);
    }


    /**
     * yml配置文件已经有了，那么这里就省了。两者二选一
     * @return
     */
    @Bean
    public RedisRateLimiter redisRateLimiter() {
        return new RedisRateLimiter(1, 60, 60);
    }

    /**
     * 注意，这里必须是 public，否则不起作用。
     * @return
     */
    @Bean
    public KeyResolver pathKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

    /**
     * IP 限流
     * @return
     */
    /*@Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }*/

    /**
     * 请求参数限流
     * @apiNote 它可以获取用户的请求参数。（注意，不建议在生产中使用）
     * @return
     */
    /*@Bean
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }*/

}
