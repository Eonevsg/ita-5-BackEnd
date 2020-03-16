package com.project.ita5.user;

import com.project.ita5.authentication.Authentication;
import com.project.ita5.database_sequence.SequenceGeneratorService;
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
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public UserController(UserRepository userRepository, Authentication authentication, SequenceGeneratorService sequenceGeneratorService){
        this.userRepository = userRepository;
        this.authentication = authentication;
        this.sequenceGeneratorService = sequenceGeneratorService;
    }

    @PostMapping("/log-in")
    public void logIn(@RequestBody User user) {
        Pair<Boolean, String> temp = authentication.authenticate(user);
        int asd = 5;
    }

    @PostMapping("/sign-up")
    public void registerNewUser(@RequestBody User user) {
        User temp = userRepository.findByUsername(user.getUsername());
        if (temp == null) {
            user.setPassword(authentication.encode(user.getPassword()));
            user.setId(Long.toString(sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME)));
            userRepository.save(user);
        }
    }
}
