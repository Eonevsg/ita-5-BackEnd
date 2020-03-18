package com.project.ita5.answer.validator;


import com.project.ita5.answer.Answer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class AnswerValidator implements ConstraintValidator<Conditional, Answer> {
//    private String[] selected;
//    private int max;
    private String message;
//    private String[] values;
    private String[] values250 = {"1", "2", "6"};
    private String[] values450 = {"3", "4", "5"};
    private String[] valuesYesNo = {"3", "4", "5", "6"};

    @Override
    public void initialize(Conditional constraintAnnotation) {
//        selected = constraintAnnotation.selected();
//        max = constraintAnnotation.max();
        message = constraintAnnotation.message();

    }

    @Override
    public boolean isValid(Answer answer, ConstraintValidatorContext context) {
        Boolean valid = true;
        try {
            if (Arrays.asList(values250).contains(answer.getQuestionId())) {
                if (answer.getAnswer().length() > 250) {
                    valid = false;
                    context.buildConstraintViolationWithTemplate("This field can't be longer than 250 characters.").addConstraintViolation();
                    message += "250";
                }
            } else if (Arrays.asList(values450).contains(answer.getQuestionId())){
                if (answer.getAnswer().length() > 450) {
                    valid = false;
                    context.buildConstraintViolationWithTemplate("This field can't be longer than 450 characters.").addConstraintViolation();
                    message += "450";
                }
            }
            if (Arrays.asList(valuesYesNo).contains(answer.getQuestionId())) {
                if (answer.getAnswer().isEmpty()) {
                    valid = false;
                    context.buildConstraintViolationWithTemplate("This field can't be blank.").addConstraintViolation();
                }
            }
        } catch (Exception e) {
            return false;
        }
        return valid;
    }
}
