package com.healthier.headachelogic.dto;

import com.healthier.headachelogic.domain.Answer;
import lombok.Data;

@Data
class AnswerDto {
    int id;
    String answer;

    AnswerDto(Answer answer) {
        this.id = answer.getAnswerId();
        this.answer = answer.getAnswer();
    }
}