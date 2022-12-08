package com.example.survey.service;

import com.example.survey.dto.QuestionDto;
import com.example.survey.dto.QuestionResponseDto;

import java.util.List;

public interface QuestionService {
    QuestionResponseDto createQuestion(QuestionDto questionDto);
    List<QuestionResponseDto> getAllQuestions(Long surveyId);
}
