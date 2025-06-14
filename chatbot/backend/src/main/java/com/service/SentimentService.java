package com.example.chatapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SentimentService {
    public String analyze(String text) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:5000/analyze?text=" + text;
        return restTemplate.getForObject(url, String.class);
    }
}
