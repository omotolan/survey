package com.example.survey.repository;

import com.example.survey.data.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    List<Survey> findByUserId(long userId);
}
