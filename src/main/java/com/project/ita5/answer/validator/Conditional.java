package com.project.ita5.answer.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Repeatable(Conditionals.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {AnswerValidator.class})
public @interface Conditional {


    String message() default "This field can't be longer than ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] selected();
    int max();
    String[] values();
}
