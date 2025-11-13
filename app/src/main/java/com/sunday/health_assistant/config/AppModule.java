package com.sunday.health_assistant.config;

import dagger.Binds;
import dagger.Module;

import com.sunday.health_assistant.domain.usecase.CalculateBmiUseCase;
import com.sunday.health_assistant.domain.interfaces.ICalculateBmiUseCase;

@Module
public abstract class AppModule {

    @Binds
    public abstract ICalculateBmiUseCase bindBmi(CalculateBmiUseCase bmiUseCase);
}
