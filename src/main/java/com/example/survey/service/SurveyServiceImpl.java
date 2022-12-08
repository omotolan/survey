package com.example.survey.service;

import com.example.survey.data.Survey;
import com.example.survey.dto.SurveyDto;
import com.example.survey.dto.SurveyResponseDto;
import com.example.survey.exception.SurveyException;
import com.example.survey.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService{
    private final SurveyRepository surveyRepository;

    public SurveyResponseDto createSurvey(long userId, SurveyDto surveyDto){
        Survey survey = new Survey();
        BeanUtils.copyProperties(surveyDto, survey);
        survey.setUserId(userId);
        Survey savedSurvey = surveyRepository.save(survey);
       return SurveyResponseDto.entityToDto(savedSurvey);
    }
    public SurveyResponseDto getSurvey(long id) throws SurveyException {
        Survey foundSurvey = surveyRepository.findById(id).orElseThrow(()-> new SurveyException("survey.does.not.exist", HttpStatus.NOT_FOUND));
        return SurveyResponseDto.entityToDto(foundSurvey);
    }

    @Override
    public List<SurveyResponseDto> getSurveyByUserId(long userId) {
       List<Survey> surveys = surveyRepository.findByUserId(userId);
      return surveys.stream().map(SurveyResponseDto::entityToDto).collect(Collectors.toList());
    }
}
