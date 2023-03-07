package com.healthier.headachelogic.dto.painArea;

import com.healthier.headachelogic.domain.Question;
import com.healthier.headachelogic.dto.QuestionDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionResponse {
    private List<QuestionDto> questions = new ArrayList<>();


    protected QuestionResponse() { }

    public QuestionResponse(Question question) {
//        System.out.println(question);
        questions.add(new QuestionDto(question));
    }
}
