package com.project.ita5.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotBlank;

public class Person {
    @Transient
    public static final String SEQUENCE_NAME = "persons_sequence";

    @Id
    private String id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Surname is required")
    private String surname;
    @NotBlank(message = "Phone is required")
    private String phone;
    @NotBlank(message = "Email is required")
    private String email;
    private String uni;

    public void setId(String id) {
        this.id = id;
    }

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
