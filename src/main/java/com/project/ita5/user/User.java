package com.project.ita5.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotBlank;

public class User {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public User() {
    }

    public User(@NotBlank String username, @NotBlank String password) {
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
