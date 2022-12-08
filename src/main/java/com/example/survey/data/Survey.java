package com.example.survey.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "survey")
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @Column(nullable = false)
    @UpdateTimestamp
    private Date updatedAt;
    @Column(nullable = false, name = "created_by")
    private Long userId;
}