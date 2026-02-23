package com.vine.service.impl;

import com.vine.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    private String systemPrompt =
            """
            你是一个叫Vine的智能助手.
            """;

    //构造器注入，自动配置方式
    public ChatServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.defaultSystem(systemPrompt).build();
    }

    @Override
    public String chatTest(String prompt) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return chatClient.prompt(prompt).call().content();

    }

    /**
     * 聊天
     *
     * @param prompt
     * @return
     * @Description: 流式返回
     */
    @Override
    public Flux<ChatResponse> streamResponse(String prompt) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return chatClient.prompt(prompt).stream().chatResponse();
    }

    @Override
    public Flux<String>streamStr(String prompt) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return chatClient.prompt(prompt).stream().content();
    }




}
