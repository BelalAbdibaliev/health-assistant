package com.sunday.health_assistant.domain.usecase;

import com.sunday.health_assistant.domain.interfaces.ICalculateBmiUseCase;
import com.sunday.health_assistant.domain.model.BmiStatus;

import javax.inject.Inject;

public class CalculateBmiUseCase implements ICalculateBmiUseCase {
    @Inject
    public CalculateBmiUseCase() {

    }

    public double execute(double weightKg, double heightMeters) {
        if (heightMeters <= 0) throw new IllegalArgumentException("Height must be positive");
        return weightKg / (heightMeters * heightMeters);
    }

    public BmiStatus getStatus(double bmi){
        if(bmi < 18.5) return BmiStatus.UnderWeight;
        if(bmi < 25) return BmiStatus.Normal;
        if(bmi < 30) return BmiStatus.OverWeight;
        if(bmi < 40) return BmiStatus.Obesity;

        return BmiStatus.MorbidObesity;
    }
}
