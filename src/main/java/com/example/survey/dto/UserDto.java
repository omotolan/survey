package com.example.survey.dto;

import com.example.survey.annotation.DoesNotExist;
import com.example.survey.annotation.PasswordValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @Size(max = 15, min = 2, message = "name.accepted_length")
    @NotBlank(message = "first_name.not_blank")
    private String firstName;
    @Size(max = 15, min = 2, message = "name.accepted_length")
    @NotBlank(message = "last_name.not_blank")
    private String lastName;
    @DoesNotExist(table = "user", columnName = "email", message = "email.already.exist")
    @Email
    private String email;
    @PasswordValid(message = "invalid.password")
    private String password;
}