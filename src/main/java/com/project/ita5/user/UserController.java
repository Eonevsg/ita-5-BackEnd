package com.project.ita5.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class UserController {
    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> fetchUsers() {
        return userService.findAll();
    }

    @PostMapping("/sign-up")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
