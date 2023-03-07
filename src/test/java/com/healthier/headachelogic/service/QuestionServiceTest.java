package com.healthier.headachelogic.service;

import com.healthier.headachelogic.domain.Question;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaNextResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @DisplayName("특정 통증 부위 시작 질문 - 코, 코 주위")
    @Test
    public void findPainAreaFirstNose() throws Exception {
        //given
        String painArea1 = "코";
        String painArea2 = "코 주위";

        //when
        Optional<Question> question1 = questionService.findPainAreaFirstQuestion(painArea1);
        Optional<Question> question2 = questionService.findPainAreaFirstQuestion(painArea2);

        //then
        Assertions.assertThat(question1.get().getQuestion()).isEqualTo("머리를 숙이거나 흔들면 두통이 심화되나요?");
        Assertions.assertThat(question1.get().getQuestion()).isEqualTo(question2.get().getQuestion());
    }

    @DisplayName("특정 통증 부위 시작 질문 - 뒷머리, 뒷목")
    @Test
    public void findPainAreaFirstBack() throws Exception {
        //given
        String painArea1 = "뒷머리";
        String painArea2 = "뒷목";

        //when
        Optional<Question> question1 = questionService.findPainAreaFirstQuestion(painArea1);
        Optional<Question> question2 = questionService.findPainAreaFirstQuestion(painArea2);

        //then
        Assertions.assertThat(question1.get().getQuestion()).isEqualTo("목을 움직이거나 손으로 목근육을 눌렀을 때 평소 느끼는 통증과 유사한가요?");
        Assertions.assertThat(question1.get().getQuestion()).isEqualTo(question2.get().getQuestion());
    }

    @DisplayName("특정 통증 부위 시작 질문 - 턱, 관자놀이")
    @Test
    public void findPainAreaFirstChin() throws Exception {
        //given
        String painArea1 = "턱";
        String painArea2 = "관자놀이";

        //when
        Optional<Question> question1 = questionService.findPainAreaFirstQuestion(painArea1);
        Optional<Question> question2 = questionService.findPainAreaFirstQuestion(painArea2);

        //then
        Assertions.assertThat(question1.get().getQuestion()).isEqualTo("입을 벌리거나 다물 때 통증이 유발되나요?");
        Assertions.assertThat(question1.get().getQuestion()).isEqualTo(question2.get().getQuestion());
    }

    @DisplayName("특정 통증 부위 시작 질문 - 얼굴피부")
    @Test
    public void findPainAreaSkin() throws Exception {
        //given
        String painArea = "얼굴피부";

        //when
        Optional<Question> question = questionService.findPainAreaFirstQuestion(painArea);

        //then
        Assertions.assertThat(question.get().getQuestion()).isEqualTo("바람이 스치거나, 세수할때 전기가 강하게 통하는 것처럼\\n찌릿한 느낌이나 찌르는 듯한 심한 통증이 있나요?");
    }

    @DisplayName("특정 통증 부위 다음 질문 - Type 1 : 다음 질문")
    @Test
    public void findPainAreaNextQuestion() throws Exception {
        //given
        int questionId = 461;
        int answerId = 1;

        //when
        HeadachePainAreaNextResponse next = questionService.findPainAreaNextQuestion(questionId, answerId);

        //then
        Assertions.assertThat(next.getType()).isEqualTo(1);
        Assertions.assertThat(next.getQuestions().get(0).getQuestion()).isEqualTo("얼굴 피부 표면에 외상 또는 찰과상이 있나요?");
    }

    @DisplayName("특정 통증 부위 다음 질문 - Type 2: 진단 결과")
    @Test
    public void findPainAreaNextQuestionResult() throws Exception {
        //given
        int questionId = 461;
        int answerId = 0;

        //when
        HeadachePainAreaNextResponse next = questionService.findPainAreaNextQuestion(questionId, answerId);

        //then
        Assertions.assertThat(next.getType()).isEqualTo(2);
        Assertions.assertThat(next.getResultDto().getResult()).isEqualTo("삼차 신경통");
    }
}