package com.healthier.headachelogic.dto;

import com.healthier.headachelogic.domain.Answer;
import com.healthier.headachelogic.domain.Question;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaFirstResponse;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class QuestionDto {
    int id;
    String question;;
    Boolean is_multiple;
    List<AnswerDto> answers = new ArrayList<>();

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.question = question.getQuestion();

        if (question.getIsMultiple() == null) {
            this.is_multiple = Boolean.FALSE;
        }
        else {
            this.is_multiple = question.getIsMultiple();
        }

        for (Answer answer : question.getAnswers()) {
            answers.add(new AnswerDto(answer));
        }
    }
}
