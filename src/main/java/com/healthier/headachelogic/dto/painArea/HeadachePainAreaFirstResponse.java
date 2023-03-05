package com.healthier.headachelogic.dto.painArea;

import com.healthier.headachelogic.domain.Answer;
import com.healthier.headachelogic.domain.Question;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class HeadachePainAreaFirstResponse {
    private List<QuestionDto> questions = new ArrayList<>();


    protected HeadachePainAreaFirstResponse() { }

    public HeadachePainAreaFirstResponse(Question question) {
        System.out.println(question);
        questions.add(new QuestionDto(question));
    }

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

    @Data
    class AnswerDto {
        int id;
        String answer;

        AnswerDto(Answer answer) {
            this.id = answer.getAnswerId();
            this.answer = answer.getAnswer();
        }
    }
}
