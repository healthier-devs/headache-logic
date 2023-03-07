package com.healthier.headachelogic.controller;

import com.healthier.headachelogic.dto.painArea.HeadachePainAreaFirstRequest;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaFirstResponse;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaNextRequest;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaNextResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuestionControllerTest {

    @Autowired
    QuestionController questionController;

    @DisplayName("API : 특정 통증 부위 시작 질문 - 뒷목")
    @Test
    void painAreaFirstQuestion() {
        // given
        HeadachePainAreaFirstRequest request = new HeadachePainAreaFirstRequest();
        request.setPainArea("뒷목");

        // when
        HeadachePainAreaFirstResponse response = questionController.PainAreaFirstQuestion(request);

        // then
        assertThat(response.getQuestions().get(0).getQuestion()).isEqualTo("목을 움직이거나 손으로 목근육을 눌렀을 때 평소 느끼는 통증과 유사한가요?");
    }

    @DisplayName("API : 특정 통증 부위 다음 질문 - 다음 질문")
    @Test
    public void painAreaNextQuestion() throws Exception {
        //given
        HeadachePainAreaNextRequest request = new HeadachePainAreaNextRequest();
        request.setQuestionId(461);
        request.setAnswerId(1);

        //when
        HeadachePainAreaNextResponse response = questionController.PainAreaNextQuestion(request);

        //then
        assertThat(response.getType()).isEqualTo(1);
        assertThat(response.getQuestions().get(0).getQuestion()).isEqualTo("얼굴 피부 표면에 외상 또는 찰과상이 있나요?");
    }

    @DisplayName("API : 특정 통증 부위 다음 질문 - 진단 결과")
    @Test
    public void painAreaNextQuestionResult() throws Exception {
        //given
        HeadachePainAreaNextRequest request = new HeadachePainAreaNextRequest();
        request.setQuestionId(461);
        request.setAnswerId(0);

        //when
        HeadachePainAreaNextResponse response = questionController.PainAreaNextQuestion(request);

        //then
        assertThat(response.getType()).isEqualTo(2);
        assertThat(response.getResultDto().getResult()).isEqualTo("삼차 신경통");
    }
}