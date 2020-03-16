package com.project.ita5.user;

import com.project.ita5.authentication.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    UserRepository userRepository;
    Authentication authentication;

    @Autowired
    public UserController(UserRepository userRepository, Authentication authentication){
        this.userRepository = userRepository;
        this.authentication = authentication;
    }

    @PostMapping("/log-in")
    public void logIn(@RequestBody User user) {

    }

    @PostMapping("/sign-up")
    public void registerNewUser(@RequestBody User user) {
        Pair<Boolean, String> temp = authentication.authenticate(user);
        int asd = 5;
    }
}
