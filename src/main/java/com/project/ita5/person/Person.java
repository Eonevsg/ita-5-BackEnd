package com.project.ita5.person;

import org.springframework.data.annotation.Id;

public class Person {
    @Id
    private String id;
    private String name;
    private String surname;
    private String phone;
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
