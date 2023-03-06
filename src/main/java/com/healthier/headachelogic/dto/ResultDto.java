package com.healthier.headachelogic.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class ResultDto {
    private int id;
    private String result;

    protected ResultDto() {}

    public ResultDto(int id, String result) {
        this.id = id;
        this.result = result;
    }
}
