package com.sunday.health_assistant.config;

import com.sunday.health_assistant.ui.main.MainActivity;

import dagger.Component;

@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
public interface AppComponent {
    void inject(MainActivity mainActivity);
}