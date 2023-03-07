package com.healthier.headachelogic.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Document(collection = "question")
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Question {
    @Id
    private ObjectId _id;

    private int id;
    private String category; // headache
    private String type; // basic, red-flag-sign, primary-headache-c, primary-headache, pain-area

    @Field(name = "pain_site")
    private String painSite;

    @Field(name = "is_first")
    private Boolean isFirst; // First Question of Pain site

    private String question;
    private String tag;
    @Field(name = "is_multiple")
    private Boolean isMultiple;
    private List<Answer> answers;
}
