package com.studysync.controller;

import com.studysync.entity.User;
import com.studysync.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public static record RegisterRequest(String username, String email, String password, String firstName, String lastName) {}
    public static record LoginRequest(String username, String password) {}

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest req) {
        var result = authService.register(req.username(), req.email(), req.password(), req.firstName(), req.lastName());
        if (result.containsKey("error")) return ResponseEntity.badRequest().body(result);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest req) {
        var result = authService.login(req.username(), req.password());
        if (result.containsKey("error")) return ResponseEntity.status(401).body(result);
        return ResponseEntity.ok(result);
    }
}
