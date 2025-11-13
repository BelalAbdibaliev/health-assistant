package com.sunday.domain.model.dto;

import java.util.List;

public class AiResponseDto {
    private List<Choice> choices;

    public String getText() {
        if (choices != null && !choices.isEmpty()) {
            return choices.get(0).message.content;
        }
        return "";
    }

    public static class Choice {
        public Message message;
    }

    public static class Message {
        public String content;
    }
}
