package com.healthier.headachelogic.dto.painArea;

import com.healthier.headachelogic.domain.Answer;
import com.healthier.headachelogic.domain.Question;
import com.healthier.headachelogic.dto.QuestionDto;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class HeadachePainAreaFirstResponse {
    private List<QuestionDto> questions = new ArrayList<>();


    protected HeadachePainAreaFirstResponse() { }

    public HeadachePainAreaFirstResponse(Question question) {
//        System.out.println(question);
        questions.add(new QuestionDto(question));
    }
}
