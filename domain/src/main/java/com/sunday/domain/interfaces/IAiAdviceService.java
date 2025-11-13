package com.sunday.domain.interfaces;

import com.sunday.domain.model.dto.BmiAdviceDto;

public interface IAiAdviceService {
    BmiAdviceDto getAdviceForBmi(double bmi);
}
