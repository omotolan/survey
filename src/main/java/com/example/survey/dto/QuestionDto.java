package com.example.survey.dto;

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
    private Long surveyId;
}
