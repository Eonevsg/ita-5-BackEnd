package com.project.ita5.authentication;

import com.project.ita5.user.User;
import com.project.ita5.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class Authentication {

    private UserRepository userRepository;
    private MongoOperations mongoOperations;


    @Autowired
    public Authentication(UserRepository userRepository, MongoOperations mongoOperations) {
        this.userRepository = userRepository;
        this.mongoOperations = mongoOperations;
    }

    public Pair<Boolean, String> authenticate(User currUser) {
        User tempUser = mongoOperations.findOne(query(where("username").is(currUser.getUsername())), User.class);
        if (tempUser == null) {
            return Pair.of(Boolean.FALSE, "");
        } else if (!tempUser.getUsername().contentEquals(currUser.getUsername())){
            return Pair.of(Boolean.FALSE, "");
        }
        return Pair.of(Boolean.TRUE, "");
    }
}
