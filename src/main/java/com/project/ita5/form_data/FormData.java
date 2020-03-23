package com.project.ita5.form_data;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

public class FormData {

    @Transient
    public static final String SEQUENCE_NAME = "form_data_sequence";

    @Id
    private String id;
    private String personId;
    private LocalDateTime submissionDateTime;
    @Size(max = 250, message = "Max length 250 characters")
    private String notes;
    @Min(value = 0, message = "Has to be higher than 0")
    @Max(value = 100, message = "Has to be lower than 100")
    private Integer applicationValuation;
    @Min(value = 0, message = "Has to be higher than 0")
    @Max(value = 100, message = "Has to be lower than 100")
    private Integer interviewValuation;
}
