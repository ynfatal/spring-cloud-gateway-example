package com.example.config;

import com.example.filter.CustomGlobalFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author Fatal
 * @date 2020/7/11 0011 21:46
 */
@Configuration(proxyBeanMethods = false)
@Profile(value = "custom_global_filter_route")
public class GatewayConfiguration {

    @Bean
    public GlobalFilter globalFilter() {
        return new CustomGlobalFilter();
    }

}
