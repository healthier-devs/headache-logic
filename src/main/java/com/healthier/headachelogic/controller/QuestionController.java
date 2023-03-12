package com.healthier.headachelogic.controller;

import com.healthier.headachelogic.domain.Question;
import com.healthier.headachelogic.dto.headache.*;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaFirstRequest;
import com.healthier.headachelogic.dto.painArea.QuestionResponse;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaNextRequest;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaNextResponse;
import com.healthier.headachelogic.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
     * 두통 기본 질문
     */
    @GetMapping("api/v2/diagnose/headache/basic")
    public QuestionResponse BasicQuestion() {
        return new QuestionResponse(questionService.findBasicQuestion());
    }

    /**
     * 두통 Red Flag Sign 질문
     */
    @GetMapping("api/v2/diagnose/headache/red-flag-sign")
    public QuestionResponse RedFlagSignQuestion() {
        return new QuestionResponse(questionService.findRedFlagSignQuestion());
    }

    /**
     * 두통 Red Flag Sign 결과
     */
    @PostMapping("api/v2/diagnose/headache/red-flag-sign")
    public HeadacheResponse RedFlagSignQuestion(@RequestBody @Valid RedFlagSignRequest request) {
        return questionService.findRedFlagSignResult(request);
    }

    /**
     * 일차성 두통 공통 질문 결과
     */
    @PostMapping("api/v2/diagnose/headache/primary-headache")
    public HeadacheResponse PrimaryHeadacheQuestion(@RequestBody @Valid PrimaryHeadacheRequest request) {
        return questionService.findPrimaryHeadacheQuestion(request);
    }

    /**
     * 일차성 두통 공통 질문 응답
     */
    @PostMapping("api/v2/diagnose/headache/primary-headache/next")
    public PrimaryHeadacheNextResponse PrimaryHeadacheNextQuestion(@RequestBody @Valid QnARequest request) {
        return questionService.findPrimaryHeadacheNextQuestion(request);
    }

    /**
     * 특정 통증 부위 시작 질문
     */

    // TODO : Exception 처리
    // TODO : 눈, 눈 주위
    @PostMapping("api/v2/diagnose/headache/pain-area/first")
    public QuestionResponse PainAreaFirstQuestion(@RequestBody @Valid HeadachePainAreaFirstRequest request) {
        Optional<Question> question = questionService.findPainAreaFirstQuestion(request.getPainArea());
        return new QuestionResponse(question.get());
    }

    /**
     * 특정 통증 부위 다음 질문
     */
    @PostMapping("api/v2/diagnose/headache/pain-area/next")
    public HeadachePainAreaNextResponse PainAreaNextQuestion(@RequestBody @Valid HeadachePainAreaNextRequest request) {
        return questionService.findPainAreaNextQuestion(request.getQuestionId(), request.getAnswerId());
    }

    /**
     * 추가적인 악화요인 질문
     */
    @GetMapping("api/v2/diagnose/headache/additional-factor")
    public QuestionResponse AdditionalFactorQuestion() {
        return new QuestionResponse(questionService.findAdditionalFactorQuestion());
    }
}
