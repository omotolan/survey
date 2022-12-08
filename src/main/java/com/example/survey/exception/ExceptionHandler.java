package com.example.survey.exception;

import com.example.survey.dto.ResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(SurveyException.class)
    public ResponseDto<?> handleAllException(SurveyException surveyException) {
        return ResponseDto.wrapErrorResult(surveyException.getMessage());
    }
}