package com.project.ita5.user;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
