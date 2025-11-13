package com.sunday.health_assistant.config;

import com.sunday.health_assistant.domain.interfaces.AiApi;
import com.sunday.health_assistant.domain.interfaces.IAiAdviceService;
import com.sunday.health_assistant.domain.service.AiAdviceService;
import com.sunday.health_assistant.data.RetrofitClient;
import com.sunday.health_assistant.BuildConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class NetworkModule {
    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return RetrofitClient.getInstance(BuildConfig.AI_API_KEY);
    }

    @Provides
    @Singleton
    AiApi provideAIApi(Retrofit retrofit) {
        return retrofit.create(AiApi.class);
    }

    @Provides
    @Singleton
    IAiAdviceService provideAiAdviceService(AiApi api) {
        return new AiAdviceService(BuildConfig.AI_API_KEY, BuildConfig.AI_MODEL);
    }
}