package com.example.survey.dto;

import com.example.survey.annotation.Exists;
import com.example.survey.enums.QuestionType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class QuestionDto {
    private QuestionType questionType;
    private String question;
    private Set<String> option;
//    @Exists(table = "survey", columnName = "id", message = "survey.does.not.exist")
    private Long surveyId;
}
