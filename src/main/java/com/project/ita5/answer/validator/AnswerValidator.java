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
            if (Arrays.asList(values250).contains(answer.getQuestionId())) {
                if (answer.getAnswer().length() > 250) {
                    context.buildConstraintViolationWithTemplate("This field can't be longer than 250 characters.").addConstraintViolation();
                    return false;
                }
            } else if (Arrays.asList(values450).contains(answer.getQuestionId())) {
                if (answer.getAnswer().length() > 450) {
                    context.buildConstraintViolationWithTemplate("This field can't be longer than 450 characters.").addConstraintViolation();
                    return false;
                }
            }
            if (Arrays.asList(valuesYesNo).contains(answer.getQuestionId())) {
                if (answer.getAnswer().isEmpty()) {
                    context.buildConstraintViolationWithTemplate("This field can't be blank.").addConstraintViolation();
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
