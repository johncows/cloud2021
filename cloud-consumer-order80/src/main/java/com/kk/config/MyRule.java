package com.kk.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangjunkang
 */
@Configuration
public class MyRule {
    @Bean
    public IRule iRule() {
        return new MyLoadBalancerRule();
    }
}
