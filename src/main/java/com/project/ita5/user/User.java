package com.project.ita5.user;


import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

public class User {
    @Id
    private String id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private UserType usertype;

    public void setId(String id) {
        this.id = id;
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
