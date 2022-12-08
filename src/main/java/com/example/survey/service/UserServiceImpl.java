package com.example.survey.service;

import com.example.survey.data.User;
import com.example.survey.dto.UserDto;
import com.example.survey.dto.UserResponseDto;
import com.example.survey.exception.SurveyException;
import com.example.survey.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserResponseDto createUser(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        User savedUser = userRepository.save(user);
        return UserResponseDto.entityToDto(savedUser);
    }

    public UserResponseDto getUser(long id) throws SurveyException {
        User foundUser = userRepository.findById(id).orElseThrow(() -> new SurveyException("user.does.not.exist", HttpStatus.NOT_FOUND));
        return UserResponseDto.entityToDto(foundUser);
    }
}
