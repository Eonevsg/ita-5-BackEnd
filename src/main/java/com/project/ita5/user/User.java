package com.project.ita5.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class User {
    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";
    @Id
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private Set<UserType> roles;

    public User() {
    }

    public User(@NotBlank String username, @NotBlank String password, Set roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
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

    public Set getRoles() {
        return roles;
    }
}
