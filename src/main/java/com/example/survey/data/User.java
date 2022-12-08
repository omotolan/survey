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
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( nullable = false)
    private String firstName;
    @Column( nullable = false)
    private String lastName;
    @Column( nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;
    @Column(nullable = false)
    @UpdateTimestamp
    private Date updatedAt;
}