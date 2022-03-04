package com.lcr.gateway.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RoutConfig
 * @Description
 * @Author licongrui
 * @Date 2022/1/17
 */
@Configuration
public class RoutConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/hey/**")
                        .uri("lb://hello-application"))
                .build();
    }

}
