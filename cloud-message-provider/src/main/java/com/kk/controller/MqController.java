package com.kk.controller;

import com.kk.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: 王骏康
 * @date: 2021/11/2 22:47
 */
@RestController
public class MqController {

    @Resource
    private IMessageProvider provider;

    @GetMapping("send")
    public String sendMessage() {
        return provider.send();
    }
}
