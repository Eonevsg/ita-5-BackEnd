package com.project.ita5.user;

import java.util.List;

public interface UserService {
    User createUser(User user);

    List<User> findAll();
}
