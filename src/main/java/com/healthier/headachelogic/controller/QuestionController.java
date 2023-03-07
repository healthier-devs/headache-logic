package com.healthier.headachelogic.controller;

import com.healthier.headachelogic.domain.Question;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaFirstRequest;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaFirstResponse;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaNextRequest;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaNextResponse;
import com.healthier.headachelogic.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@Validated
@RestController
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    /**
     * 특정 통증 부위 시작 질문
     */

    // TODO : Exception 처리
    // TODO : 눈, 눈 주위
    @PostMapping("api/v2/diagnose/headache/pain-area/first")
    public HeadachePainAreaFirstResponse PainAreaFirstQuestion(@RequestBody @Valid HeadachePainAreaFirstRequest request) {
        Optional<Question> question = questionService.findPainAreaFirstQuestion(request.getPainArea());
        return new HeadachePainAreaFirstResponse(question.get());
    }

    /**
     * 특정 통증 부위 다음 질문
     */
    @PostMapping("api/v2/diagnose/headache/pain-area/next")
    public HeadachePainAreaNextResponse PainAreaNextQuestion(@RequestBody @Valid HeadachePainAreaNextRequest request) {
        return questionService.findPainAreaNextQuestion(request.getQuestionId(), request.getAnswerId());
    }
}
