package com.kk.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * @author wangjunkang
 */
@Component
@Slf4j
public class MyLogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("全局过滤器 监测中！");
        log.info(LocalDateTime.now().toString());
        if (LocalDateTime.now().getLong(ChronoField.SECOND_OF_DAY) % 2 == 0) {
            exchange.getResponse().setStatusCode(HttpStatus.CONFLICT);
            log.error("非法用户！！！");
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
