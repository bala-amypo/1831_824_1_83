package com.example.demo.controller;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @Operation(summary = "Register new user")
    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return service.register(
                request.email,
                request.password,
                request.role
        );
    }

    @Operation(summary = "Login user")
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return service.login(
                request.email,
                request.password
        );
    }
}
