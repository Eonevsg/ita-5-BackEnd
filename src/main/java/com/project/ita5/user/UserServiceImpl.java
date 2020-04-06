package com.project.ita5.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            Set<UserType> authorities = new HashSet<UserType>();
            authorities.add(UserType.HR);
            userRepository.save(new User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()), authorities));
        }
        return userRepository.findByUsername(user.getUsername());
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User deleteUser(String id) {
        userRepository.deleteById(id);
        return userRepository.findById(id).orElse(null);
    }
}
