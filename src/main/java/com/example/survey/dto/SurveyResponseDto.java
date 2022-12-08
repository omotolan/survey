package com.example.survey.dto;

import com.example.survey.data.Survey;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class SurveyResponseDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String title;
    private String description;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long userId;

    public static SurveyResponseDto entityToDto(Survey survey){
        SurveyResponseDto surveyResponseDto = new SurveyResponseDto();
        BeanUtils.copyProperties(survey, surveyResponseDto);
        return surveyResponseDto;
    }
}