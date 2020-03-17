package com.project.ita5.user;

import com.project.ita5.database_sequence.SequenceGeneratorService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping
    public List<User> getUsers() {
        List<User> temp = userRepository.findAll();
        temp.forEach(user -> user.setPassword(null));
        return temp;
    }
}
