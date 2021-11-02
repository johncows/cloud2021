package com.kk.service.impl;

import cn.hutool.core.lang.UUID;
import com.kk.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author: 王骏康
 * @date: 2021/11/2 22:38
 */
//定义消息的推送管道
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息推送管道

    @Override
    public String send() {
        String message = UUID.randomUUID()+"";
        output.send(MessageBuilder.withPayload(message).build());
        log.info("发送消息流水号:{}",message);
        return message;
    }

}
