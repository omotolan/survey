package com.example.survey.dto;

import com.example.survey.data.Question;
import com.example.survey.enums.QuestionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Set;

@Setter
@Getter
public class QuestionResponseDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private QuestionType questionType;
    private String question;
    private Set<String> option;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long surveyId;

    public static QuestionResponseDto entityToDto(Question question){
        QuestionResponseDto questionResponseDto = new QuestionResponseDto();
        BeanUtils.copyProperties(question, questionResponseDto);
        return questionResponseDto;
    }
}
