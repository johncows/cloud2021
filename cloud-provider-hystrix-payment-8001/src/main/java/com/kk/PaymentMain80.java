package com.kk;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import javax.servlet.Servlet;

/**
 * @author wangjunkang
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class PaymentMain80 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain80.class, args);
    }

    //
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<Servlet> servletServletRegistrationBean = new ServletRegistrationBean<>(hystrixMetricsStreamServlet);
        servletServletRegistrationBean.setLoadOnStartup(1);
        servletServletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletServletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletServletRegistrationBean;
    }

}
