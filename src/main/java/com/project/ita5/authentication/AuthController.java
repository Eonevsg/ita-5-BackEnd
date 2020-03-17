package com.project.ita5.authentication;

import com.project.ita5.user.User;
import com.project.ita5.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

//    AuthenticationManager authenticationManager;
//    JwtTokenProvider jwtTokenProvider;
//    UserRepository userRepository;
//    CustomUserDetailsService customUserDetailsService;
//    @Autowired
//    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserRepository userRepository, CustomUserDetailsService customUserDetailsService) {
//        this.authenticationManager = authenticationManager;
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.userRepository = userRepository;
//        this.customUserDetailsService = customUserDetailsService;
//    }

//    @PostMapping("/login")
//    public ResponseEntity login(@RequestBody AuthBody data) {
//        try {
//            String username = data.getUsername();
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
//            String token = jwtTokenProvider.createToken(username, this.userRepository.findByUsername(username).getRoles());
//            Map<Object, Object> model = new HashMap<>();
//            model.put("username", username);
//            model.put("token", token);
//            return ok(model);
//        } catch (AuthenticationException e) {
//            throw new BadCredentialsException("Invalid email/password supplied");
//        }
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity register(@RequestBody User user) {
//        User userExists = customUserDetailsService.findUserByUsername(user.getUsername());
//        if (userExists != null) {
//            throw new BadCredentialsException("User with username: " + user.getUsername() + " already exists");
//        }
//        customUserDetailsService.saveUser(user);
//        Map<Object, Object> model = new HashMap<>();
//        model.put("message", "User registered successfully");
//        return ok(model);
//    }

}
