package com.vine.controller;

import com.vine.service.ChatService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("hello")
public class HelloController {

    //http://localhost:8080/hello/world

    @Resource
    private ChatService chatService;


    @GetMapping("world")
    public String World() {
        return "hello world";
    }

    //http://localhost:8080/hello/chat?message=hello
    @GetMapping("chat")
    public String chat(String message) {
        return chatService.chatTest(message);
    }

    @GetMapping("chat/stream/response")
    public Flux<ChatResponse> chatResponse(String message, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        return chatService.streamResponse( message);
    }


    //http://localhost:8080/hello/chat/stream/str?message=hello
    @GetMapping("chat/stream/str")
    public Flux<String> chatStream(String message, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        return chatService.streamStr( message);
    }

}

