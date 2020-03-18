package com.project.ita5.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
    @Transient
    public static final String SEQUENCE_NAME = "persons_sequence";

    @Id
    private String id;
    @NotBlank(message = "Name is required")
    @Size(min = 1, max = 100, message="Name must be 1-100 characters long")
    private String name;
    @NotBlank(message = "Surname is required")
    @Size(min = 1, max = 100, message="Surname must be 1-100 characters long")
    private String surname;
    @NotBlank(message = "Phone is required")
    @Pattern(
            regexp = "^\\+?[0-9]+$",
            message = "Phone number should be vaild"
    )
    private String phone;
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    private String uni;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUni() {
        return uni;
    }
}
