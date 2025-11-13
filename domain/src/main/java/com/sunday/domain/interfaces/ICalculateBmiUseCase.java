package com.sunday.domain.interfaces;

import com.sunday.domain.model.BmiStatus;

public interface ICalculateBmiUseCase {
    double execute(double weight, double height);
    BmiStatus getStatus(double bmi);
}
