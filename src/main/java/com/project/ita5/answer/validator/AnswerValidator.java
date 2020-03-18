package com.project.ita5.answer.validator;


import com.project.ita5.answer.Answer;
import javafx.util.Pair;
import org.springframework.beans.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class AnswerValidator implements ConstraintValidator<Conditional, String[]> {
    private String[] selected;
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
    public boolean isValid(String[] objectToValidate, ConstraintValidatorContext context) {
        Boolean valid = false;
        try {
            if (Arrays.asList(values).contains(objectToValidate[0])) {
                if (objectToValidate[1].length() > max) {
                    valid = false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return valid;
    }
}
