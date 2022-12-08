package com.example.survey.controller;

import com.example.survey.MockUtils;
import com.example.survey.dto.*;
import com.example.survey.enums.ResponseStatus;
import com.example.survey.service.QuestionService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

class QuestionControllerTest {

    private final QuestionService questionService = MockUtils.questionService;
    private final QuestionController questionController = new QuestionController(questionService);

    @Test
    public void testToCreatQuestion() {
        QuestionResponseDto questionResponseDto = new QuestionResponseDto();
        doReturn(questionResponseDto).when(questionService).createQuestion(any(QuestionDto.class));
        QuestionDto questionDto = new QuestionDto();
        ResponseDto<?> questionResponseDtoSecond = questionController.createQuestion(anyLong(), questionDto);
        assertEquals(ResponseStatus.SUCCESS, questionResponseDtoSecond.getStatus());
    }

    @Test
    public void testToGetUserById() {
       List<QuestionResponseDto> questionResponseDto = new ArrayList<>();
        doReturn(questionResponseDto).when(questionService).getAllQuestions(anyLong());
        long id = 1L;
        ResponseDto<?> questionResponseDtoSecond = questionController.getQuestions(id);
        assertEquals(ResponseStatus.SUCCESS, questionResponseDtoSecond.getStatus());
    }
}