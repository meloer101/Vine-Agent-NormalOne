package com.vine.service;

import org.springframework.ai.chat.model.ChatResponse;
import reactor.core.publisher.Flux;

public interface ChatService {
    public String chatTest(String prompt);

    //description: 流式返回JSON
    public Flux<ChatResponse> streamResponse(String prompt);

    //description: 流式返回字符串
    public Flux<String> streamStr(String prompt);
}
