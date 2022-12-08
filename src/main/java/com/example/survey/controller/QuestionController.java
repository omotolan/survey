package com.example.survey.controller;

import com.example.survey.dto.QuestionDto;
import com.example.survey.dto.ResponseDto;
import com.example.survey.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping("create/{surveyId}")
    public ResponseDto<?> createQuestion(@PathVariable Long surveyId, @Valid @RequestBody QuestionDto questionDto) {
        questionDto.setSurveyId(surveyId);
        return ResponseDto.wrapSuccessResult(questionService.createQuestion(questionDto), "request.successful");
    }

    @GetMapping("{surveyId}")
    public ResponseDto<?> getQuestions(@PathVariable Long surveyId) {
        return ResponseDto.wrapSuccessResult(questionService.getAllQuestions(surveyId), "request.successful");
    }
}