package com.sunday.health_assistant.domain.service;

import com.sunday.health_assistant.data.RetrofitClient;
import com.sunday.health_assistant.domain.interfaces.AiApi;
import com.sunday.health_assistant.domain.interfaces.IAiAdviceService;
import com.sunday.health_assistant.domain.model.dto.AiRequestDto;
import com.sunday.health_assistant.domain.model.dto.AiResponseDto;
import com.sunday.health_assistant.domain.model.dto.BmiAdviceDto;

import java.io.IOException;

import retrofit2.Retrofit;

public class AiAdviceService implements IAiAdviceService {

    private final AiApi api;
    private final String model;

    public AiAdviceService(String apiKey, String model) {
        Retrofit retrofit = RetrofitClient.getInstance(apiKey);
        this.api = retrofit.create(AiApi.class);
        this.model = model;
    }

    @Override
    public BmiAdviceDto getAdviceForBmi(double bmi) {
        String prompt = "Ты врач. ИМТ=" + bmi +
                ". Дай совет и описание состояния.";

        AiRequestDto request = new AiRequestDto(model, prompt);

        try {
            retrofit2.Response<AiResponseDto> response = api.getCompletion(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                String text = response.body().getText();
                return new BmiAdviceDto(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new BmiAdviceDto("Ошибка при получении совета.");
    }
}