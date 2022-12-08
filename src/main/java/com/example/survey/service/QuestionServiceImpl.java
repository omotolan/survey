package com.example.survey.service;

import com.example.survey.data.Question;
import com.example.survey.dto.QuestionDto;
import com.example.survey.dto.QuestionResponseDto;
import com.example.survey.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
    private final QuestionRepository questionRepository;

    public QuestionResponseDto createQuestion(QuestionDto questionDto){
        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);
        Question savedQuestion = questionRepository.save(question);
      return   QuestionResponseDto.entityToDto(savedQuestion);
    }

    public List<QuestionResponseDto> getAllQuestions(Long surveyId){
        List<Question> questions = questionRepository.findBySurveyId(surveyId);
       return questions.stream()
               .map(QuestionResponseDto::entityToDto).collect(Collectors.toList());
    }
}