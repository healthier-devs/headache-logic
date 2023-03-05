package com.healthier.headachelogic.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
public class Answer {
    private int answerId;
    private String answer;
    private String tag;
    private boolean isDecisive;
    private int nextQuestionId;
    private String question;
    private int resultId;
    private String result;
}
