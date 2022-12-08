package com.example.survey.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurveyDto {
    @Size(max = 40, min = 2, message = "survey.title.accepted_length")
    @NotBlank(message = "survey_title.not_blank")
    private String title;
    @NotBlank(message = "description.cannot.be.blank")
    @Size(max = 500, message = "description.unaccepted.length")
    private String description;
}
