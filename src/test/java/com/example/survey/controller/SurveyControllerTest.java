package com.example.survey.controller;

import com.example.survey.MockUtils;
import com.example.survey.dto.ResponseDto;
import com.example.survey.dto.SurveyDto;
import com.example.survey.dto.SurveyResponseDto;
import com.example.survey.enums.ResponseStatus;
import com.example.survey.exception.SurveyException;
import com.example.survey.service.SurveyService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

class SurveyControllerTest {

    private final SurveyService surveyService = MockUtils.surveyService;
    private final SurveyController surveyController = new SurveyController(surveyService);

    @Test
    public void testToCreateSurvey() {
        SurveyResponseDto surveyResponseDto = new SurveyResponseDto();
        doReturn(surveyResponseDto).when(surveyService).createSurvey(anyLong(), any(SurveyDto.class));
        SurveyDto surveyDto = new SurveyDto();
        ResponseDto<?> response = surveyController.createSurvey(surveyDto);
        assertEquals(ResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testToGetSurveyById() throws SurveyException {
        SurveyResponseDto surveyResponseDto = new SurveyResponseDto();
        doReturn(surveyResponseDto).when(surveyService).getSurvey(anyLong());
        ResponseDto<?> response = surveyController.getSurvey(1L);
        assertEquals(ResponseStatus.SUCCESS, response.getStatus());
    }

    @Test
    public void testForLoggedInUserToGetAllSurvey() {
        List<SurveyResponseDto> surveyResponseDto = new ArrayList<>();
        doReturn(surveyResponseDto).when(surveyService).getSurveyByUserId(anyLong());
        ResponseDto<?> response = surveyController.getAllSurvey();
        assertEquals(ResponseStatus.SUCCESS, response.getStatus());
    }
}