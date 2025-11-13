package com.sunday.health_assistant.domain.interfaces;

import com.sunday.health_assistant.domain.model.BmiStatus;

public interface ICalculateBmiUseCase {
    double execute(double weight, double height);
    BmiStatus getStatus(double bmi);
}
