package com.healthier.headachelogic.domain;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Document(collection = "question")
public class Question {

    private int id;
    private String category;
    private String type;
    private String painSite;
    private String question;
    private String tag;
    private Boolean isMultiple;

    private List<Answer> answers;
}
