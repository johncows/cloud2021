package com.kk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author wangjunkang
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewaySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaySpringBootApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocator routeLocator = routes.route("baidu", r ->
                r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routeLocator;
    }

}
