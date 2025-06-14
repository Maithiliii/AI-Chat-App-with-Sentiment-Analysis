package com.example.chatapp.controller;

import com.example.chatapp.model.Message;
import com.example.chatapp.service.SentimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SentimentService sentimentService;

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/message")
    public void receiveMessage(Message message) {
        String sentiment = sentimentService.analyze(message.getContent());
        message.setSentiment(sentiment);
        template.convertAndSend("/topic/messages", message);
    }
}
