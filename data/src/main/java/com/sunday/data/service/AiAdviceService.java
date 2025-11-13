package com.sunday.data.service;

import com.sunday.data.remote.AiApi;
import com.sunday.data.remote.RetrofitClient;
import com.sunday.domain.interfaces.IAiAdviceService;
import com.sunday.domain.model.dto.AiRequestDto;
import com.sunday.domain.model.dto.AiResponseDto;
import com.sunday.domain.model.dto.BmiAdviceDto;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class AiAdviceService implements IAiAdviceService {

    private final AiApi api;
    private final String model;

    @Inject
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
