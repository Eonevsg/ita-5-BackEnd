package com.project.ita5.authentication;

import com.project.ita5.user.User;
import com.project.ita5.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.util.Pair;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class Authentication {

    private UserRepository userRepository;
    private MongoOperations mongoOperations;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public Authentication(UserRepository userRepository, MongoOperations mongoOperations, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.mongoOperations = mongoOperations;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Pair<Boolean, String> authenticate(User currUser) {
        User tempUser = mongoOperations.findOne(query(where("username").is(currUser.getUsername())), User.class);
        if (tempUser == null) {//if no such user
            return Pair.of(Boolean.FALSE, "");
        } else if (!tempUser.getUsername().contentEquals(currUser.getUsername())){
            return Pair.of(Boolean.FALSE, "");
        } else if (!matches(currUser.getPassword(), tempUser.getPassword())) { //if password incorrect
            return Pair.of(Boolean.FALSE, "");
        } else {
            return Pair.of(Boolean.TRUE, "");
        }
    }

    public String encode(String pass) {
        return bCryptPasswordEncoder.encode(pass);
    }
    public boolean matches(String password, String encodedPassword) {
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }
}
