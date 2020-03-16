package com.project.ita5.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Person {
    @Transient
    public static final String SEQUENCE_NAME = "persons_sequence";

    @Id
    private long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String uni;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
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
