package com.example.survey.service;

import com.example.survey.dto.SurveyDto;
import com.example.survey.dto.SurveyResponseDto;
import com.example.survey.exception.SurveyException;

import java.util.List;

public interface SurveyService {

    SurveyResponseDto createSurvey(long userId, SurveyDto surveyDto);

    SurveyResponseDto getSurvey(long id) throws SurveyException;

    List<SurveyResponseDto> getSurveyByUserId(long userId);
}