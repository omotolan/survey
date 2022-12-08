package com.example.survey.controller;

import com.example.survey.MockUtils;
import com.example.survey.dto.ResponseDto;
import com.example.survey.dto.UserDto;
import com.example.survey.dto.UserResponseDto;
import com.example.survey.enums.ResponseStatus;
import com.example.survey.exception.SurveyException;
import com.example.survey.service.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;

class UserControllerTest {
    private final UserService userService = MockUtils.userService;
    private final UserController userController = new UserController(userService);

    @Test
    public void testToCreatAUser() {
        UserResponseDto userResponseDto = new UserResponseDto();
        doReturn(userResponseDto).when(userService).createUser(any(UserDto.class));
        UserDto userDto = new UserDto();
        ResponseDto<?> userResponseDtoSecond = userController.createUser(userDto);
        assertEquals(ResponseStatus.SUCCESS, userResponseDtoSecond.getStatus());
    }

    @Test
    public void testToGetUserById() throws SurveyException {
        UserResponseDto userResponseDto = new UserResponseDto();
        doReturn(userResponseDto).when(userService).getUser(anyLong());
        long id = 1L;
        ResponseDto<?> userResponseDtoSecond = userController.getUser(id);
        assertEquals(ResponseStatus.SUCCESS, userResponseDtoSecond.getStatus());
    }
}