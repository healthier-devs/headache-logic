package com.healthier.headachelogic.controller;

import com.healthier.headachelogic.dto.painArea.HeadachePainAreaFirstRequest;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaFirstResponse;
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

    @DisplayName("서비스 : 특정 통증 부위 시작 질문 - 뒷목")
    @Test
    void painAreaFirstQuestion() {
        // given
        HeadachePainAreaFirstRequest request = new HeadachePainAreaFirstRequest();
        request.setPain_area("뒷목");

        // when
        HeadachePainAreaFirstResponse response = questionController.PainAreaFirstQuestion(request);

        // then
        assertThat(response.getQuestions().get(0).getQuestion()).isEqualTo("목을 움직이거나 손으로 목근육을 눌렀을 때 평소 느끼는 통증과 유사한가요?");
    }
}