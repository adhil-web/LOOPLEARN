package com.studysync.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {

    public String getResponse(String question) {
        // For now, just return a dummy response
        return "This is a response to: " + question;
    }
}
