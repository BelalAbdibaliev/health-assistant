package com.sunday.health_assistant.domain.model.dto;

public class BmiAdviceDto {
    private final String adviceText;

    public BmiAdviceDto(String adviceText) {
        this.adviceText = adviceText;
    }

    public String getAdviceText() {
        return adviceText;
    }
}
