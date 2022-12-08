package com.example.survey.controller;

import com.example.survey.dto.ResponseDto;
import com.example.survey.dto.UserDto;
import com.example.survey.exception.SurveyException;
import com.example.survey.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("create")
    public ResponseDto<?> createUser(@RequestBody @Valid UserDto userDto) {
        return ResponseDto.wrapSuccessResult(userService.createUser(userDto), "request.successful");
    }

    @GetMapping("{userId}")
    public ResponseDto<?> getUser(@PathVariable Long userId) throws SurveyException {
        return ResponseDto.wrapSuccessResult(userService.getUser(userId), "request.successful");
    }
}