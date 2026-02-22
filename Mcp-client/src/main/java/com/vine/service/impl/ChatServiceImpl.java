package com.vine.service.impl;

import com.vine.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
    private ChatClient chatClient;

    //构造器注入，自动配置方式
    public ChatServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultSystem("你是一个叫Vine的智能助手.").build();
    }

    @Override
    public String chatTest(String prompt) {
        return chatClient.prompt(prompt).call().content();

    }
}
