package com.sunday.domain.model.dto;

import java.util.List;

public class AiRequestDto {
    private final String model;
    private final List<Message> messages;

    public AiRequestDto(String model, String prompt) {
        this.model = model;
        this.messages = List.of(new Message("user", prompt));
    }

    public static class Message {
        private final String role;
        private final String content;

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }
    }
}
