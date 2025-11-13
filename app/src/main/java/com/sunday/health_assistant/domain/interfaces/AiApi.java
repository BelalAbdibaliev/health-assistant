package com.sunday.health_assistant.domain.interfaces;

import com.sunday.health_assistant.domain.model.dto.AiRequestDto;
import com.sunday.health_assistant.domain.model.dto.AiResponseDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AiApi {
    @POST("v1/chat/completions")
    Call<AiResponseDto> getCompletion(@Body AiRequestDto request);
}
