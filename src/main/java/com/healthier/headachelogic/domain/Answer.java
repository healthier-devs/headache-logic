package com.healthier.headachelogic.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Answer {
    @Field(name = "answer_id")
    private int answerId;
    private String answer;
    private String tag;
    @Field(name = "is_decisive")
    private boolean isDecisive;
    @Field(name = "next_question_id")
    private int nextQuestionId;
    private String question;
    @Field(name = "result_id")
    private int resultId;
    private String result;
}
