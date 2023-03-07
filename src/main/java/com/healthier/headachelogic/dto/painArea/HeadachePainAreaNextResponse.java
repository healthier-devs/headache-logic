package com.healthier.headachelogic.dto.painArea;

import com.healthier.headachelogic.domain.Question;
import com.healthier.headachelogic.dto.QuestionDto;
import com.healthier.headachelogic.dto.ResultDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HeadachePainAreaNextResponse {
    private int type;
    private List<QuestionDto> questions = new ArrayList<>();
    ResultDto resultDto;

    //생성자
    protected HeadachePainAreaNextResponse() {}

    //1) 생성자 : 다음 질문 반환
    public HeadachePainAreaNextResponse(Question question) {
        type = 1;
        questions.add(new QuestionDto(question));
    }

    //2) 생성자 : 진단 결과 안내
    public HeadachePainAreaNextResponse(int resultId, String result) {
        type = 2;
        resultDto = new ResultDto(resultId, result);
    }
}

