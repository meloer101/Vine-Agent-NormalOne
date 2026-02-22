package com.vine.controller;

import com.vine.service.ChatService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

