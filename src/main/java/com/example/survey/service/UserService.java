package com.example.survey.service;

import com.example.survey.dto.UserDto;
import com.example.survey.dto.UserResponseDto;
import com.example.survey.exception.SurveyException;

public interface UserService {

    UserResponseDto createUser(UserDto userDto);
    UserResponseDto getUser(long id) throws SurveyException;
}
