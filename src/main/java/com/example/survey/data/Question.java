package com.example.survey.data;

import com.example.survey.enums.QuestionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;
    @Column(nullable = false)
    private String question;
    @Column(nullable = false)
    private Long surveyId;
    @ElementCollection
    @CollectionTable(
            name="question_options",
            joinColumns=@JoinColumn(name="question_id")
    )
    @Column(name="options")
    private Set<String> option;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @Column(nullable = false)
    @UpdateTimestamp
    private Date updatedAt;
}