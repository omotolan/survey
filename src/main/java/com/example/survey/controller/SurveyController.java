package com.example.survey.controller;

import com.example.survey.dto.ResponseDto;
import com.example.survey.dto.SurveyDto;
import com.example.survey.exception.SurveyException;
import com.example.survey.service.SurveyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyService surveyService;

    @PostMapping("create")
    public ResponseDto<?> createSurvey(@RequestBody @Valid SurveyDto surveyDto) {
        /**
         *get userId from authenticated user(meaning only logged in user can access this endpoint)
         * */
        long userId = 1L;
        return ResponseDto.wrapSuccessResult(surveyService.createSurvey(userId, surveyDto), "request.successful");
    }

    @GetMapping("{surveyId}")
    public ResponseDto<?> getSurvey(@PathVariable Long surveyId) throws SurveyException {
        return ResponseDto.wrapSuccessResult(surveyService.getSurvey(surveyId), "request.successful");
    }

    @GetMapping("get-all-survey")
    public ResponseDto<?> getAllSurvey() {
        /**
         *get userId from authenticated user(meaning only logged in user can access this endpoint)
         * */
        long userId = 1L;
        return ResponseDto.wrapSuccessResult(surveyService.getSurveyByUserId(userId), "request.successful");
    }
}