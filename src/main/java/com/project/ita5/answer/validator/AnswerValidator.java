package com.project.ita5.answer.validator;


import com.project.ita5.answer.Answer;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class AnswerValidator implements ConstraintValidator<Conditional, Object> {
    private String selected;
    private int max;
    private String message;
    private String[] values;

    @Override
    public void initialize(Conditional constraintAnnotation) {
        selected = constraintAnnotation.selected();
        max = constraintAnnotation.max();
        message = constraintAnnotation.message();
        values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object objectToValidate, ConstraintValidatorContext context) {
        Boolean valid = false;
        Answer actualValue = ((Answer) objectToValidate);
        try {
            if (Arrays.asList(values).contains(actualValue)) {
                valid = false;
            }
        } catch (Exception e) {
            return false;
        }
        return valid;
    }
}
