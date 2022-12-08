package com.example.survey.annotation.validator;

import com.example.survey.annotation.DoesNotExist;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Optional;

@RequiredArgsConstructor
public class DoesNotExistValidator implements ConstraintValidator<DoesNotExist, Object> {

    private final JdbcTemplate jdbcTemplate;
    private DoesNotExist doesNotExist;

    @Override
    public void initialize(DoesNotExist constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        doesNotExist = constraintAnnotation;
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (doesNotExist.nullable() && o == null) return true;
        if (o == null) return false;
        String table = doesNotExist.table();
        String columnName = doesNotExist.columnName();
        String query = doesNotExist.query();

        if (query == null || query.trim().isEmpty()){
            query = "SELECT COUNT(*) FROM %s WHERE %s = ?";
            query = String.format(query, table, columnName);
        }
        int count = Optional.ofNullable(jdbcTemplate.queryForObject(query, Integer.class, o)).orElse(0);
        return count == 0;
    }
}
