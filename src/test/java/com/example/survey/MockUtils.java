package com.example.survey;


import com.example.survey.controller.QuestionController;
import com.example.survey.controller.SurveyController;
import com.example.survey.controller.UserController;
import com.example.survey.service.QuestionService;
import com.example.survey.service.SurveyService;
import com.example.survey.service.UserService;

import static org.mockito.Mockito.mock;

public class MockUtils {

    public static final UserService userService = mock(UserService.class);

    public static final QuestionService questionService = mock(QuestionService.class);
    public static final SurveyService surveyService = mock(SurveyService.class);

    public static UserController userController() {
        return new UserController(userService);
    }

    public static QuestionController questionController() {
        return new QuestionController(questionService);
    }

    public static SurveyController surveyController() {
        return new SurveyController(surveyService);
    }

}