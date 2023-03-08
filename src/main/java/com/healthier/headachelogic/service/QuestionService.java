package com.healthier.headachelogic.service;

import com.healthier.headachelogic.domain.Answer;
import com.healthier.headachelogic.domain.Question;
import com.healthier.headachelogic.domain.Type;
import com.healthier.headachelogic.dto.painArea.HeadachePainAreaNextResponse;
import com.healthier.headachelogic.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    /**
     * 두통 기본 질문 조회
     */
    public List<Question> findBasicQuestion() {
        return questionRepository.findByType(Type.BASIC.label());
    }

    /**
     * 두통 Red Flag Sign 질문 조회
     */
    public List<Question> findRedFlagSignQuestion() {
        return questionRepository.findByType(Type.REDFLAGSIGN.label());
    }

    /**
     * 특정 통증 부위 시작 질문 조회
     */
    public Optional<Question> findPainAreaFirstQuestion(String painSite) {
        return questionRepository.findByPainSiteContainsAndIsFirst(painSite, true);
    }

    /**
     * 특정 통증 부위 다음 질문 조회
     * type 1 : 다음 질문
     * type 2 : 진단 결과 안내
     */
    public HeadachePainAreaNextResponse findPainAreaNextQuestion(int questionId, int answerId) {
        Optional<Question> question = questionRepository.findById(questionId);
        Answer answer = question.get().getAnswers().get(answerId); //답변 정보

        //다음 질문이 존재할 때
        if (!answer.isDecisive()) {
            int nextQuestionId = answer.getNextQuestionId(); //다음 질문 id
            return new HeadachePainAreaNextResponse(questionRepository.findById(nextQuestionId).get());
        }

        //다음 질문이 존재하지 않을 때
        else {
            return new HeadachePainAreaNextResponse(answer.getResultId(), answer.getResult());
        }
    }

    /**
     * 추가적인 악화 요인 질문 조회
     */
    public Question findAdditionalFactorQuestion() {
        List<Question> questions = questionRepository.findByType("additional-factor");
        return questions.get(0);
    }
}
