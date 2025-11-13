package com.sunday.health_assistant.config;

import com.sunday.data.remote.AiApi;
import com.sunday.data.remote.RetrofitClient;
import com.sunday.data.service.AiAdviceService;
import com.sunday.domain.interfaces.IAiAdviceService;
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
