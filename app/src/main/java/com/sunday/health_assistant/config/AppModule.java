package com.sunday.health_assistant.config;

import com.sunday.domain.interfaces.ICalculateBmiUseCase;
import com.sunday.domain.usecase.CalculateBmiUseCase;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class AppModule {

    @Binds
    public abstract ICalculateBmiUseCase bindBmi(CalculateBmiUseCase bmiUseCase);
}
