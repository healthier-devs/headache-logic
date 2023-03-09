package com.healthier.headachelogic.dto.redFlagSign;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.healthier.headachelogic.dto.QuestionDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class RedFlagSignResponse {
    private int type;
    private String message;
    private List<QuestionDto> questions;
}
