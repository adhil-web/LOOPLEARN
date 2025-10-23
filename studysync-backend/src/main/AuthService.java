package com.studysync.service;

import com.studysync.entity.User;
import com.studysync.repository.UserRepository;
import com.studysync.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Map<String, Object> register(String username, String email, String password, String firstName, String lastName) {
        Map<String, Object> out = new HashMap<>();
        if (userRepository.existsByUsername(username)) {
            out.put("error", "Username already taken");
            return out;
        }
        if (userRepository.existsByEmail(email)) {
            out.put("error", "Email already registered");
            return out;
        }

        User u = new User();
        u.setUsername(username);
        u.setEmail(email);
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setPassword(passwordEncoder.encode(password));
        u.setRole("ROLE_USER"); // default role
        userRepository.save(u);

        String token = jwtUtil.generateToken(username);
        out.put("token", token);
        out.put("user", u);
        return out;
    }

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> out = new HashMap<>();
        Optional<User> maybe = userRepository.findByUsername(username);
        if (maybe.isEmpty()) {
            out.put("error", "Bad credentials");
            return out;
        }
        User u = maybe.get();
        if (!passwordEncoder.matches(password, u.getPassword())) {
            out.put("error", "Bad credentials");
            return out;
        }
        String token = jwtUtil.generateToken(username);
        out.put("token", token);
        out.put("user", u);
        return out;
    }
}
