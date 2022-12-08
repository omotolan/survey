package com.example.survey.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SurveyException  extends Exception{
    private final HttpStatus status;
    public SurveyException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

}
