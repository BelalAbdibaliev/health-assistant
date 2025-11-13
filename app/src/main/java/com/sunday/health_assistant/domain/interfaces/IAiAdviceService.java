package com.sunday.health_assistant.domain.interfaces;

import com.sunday.health_assistant.domain.model.dto.BmiAdviceDto;

public interface IAiAdviceService {
    BmiAdviceDto getAdviceForBmi(double bmi);
}
