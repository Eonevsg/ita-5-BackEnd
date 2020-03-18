package com.project.ita5.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User createUser(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (userRepository.findByUsername(user.getUsername()) == null) {
            userRepository.save(new User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword())));
        }
        return userRepository.findByUsername(user.getUsername());
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
