package com.healthier.headachelogic.dto;

import com.healthier.headachelogic.domain.Answer;
import lombok.Data;

@Data
class AnswerDto {
    int answer_id;
    String answer;

    AnswerDto(Answer answer) {
        this.answer_id = answer.getAnswerId();
        this.answer = answer.getAnswer();
    }
}