package com.healthier.headachelogic.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document(collection = "question")
public class Question {

    private int id;
    private String category; // headache
    private String type; // basic, red-flag-sign, primary-headache-c, primary-headache, pain-area
    private String painSite;
    private String question;
    private String tag;
    private Boolean isMultiple;
    private List<Answer> answers;
}
