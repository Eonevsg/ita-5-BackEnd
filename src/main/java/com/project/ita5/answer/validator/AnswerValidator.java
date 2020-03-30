package com.project.ita5.answer.validator;

import com.project.ita5.answer.Answer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class AnswerValidator implements ConstraintValidator<Conditional, Answer> {
    private String message;
    private String[] values250 = {"1", "2", "6"};
    private String[] values450 = {"3", "4", "5"};
    private String[] valuesYesNo = {"3", "4", "5", "6"};

    @Override
    public void initialize(Conditional constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Answer answer, ConstraintValidatorContext context) {
        try {
            if (answer.getAnswer().length() > 1000) {
                context.buildConstraintViolationWithTemplate("This field can't be longer than 1000 characters.").addConstraintViolation();
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
