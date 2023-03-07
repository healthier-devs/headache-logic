package com.healthier.headachelogic.dto.painArea;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class HeadachePainAreaNextRequest {
    private int questionId;
    private int answerId;
}
