package com.techup.spring_demo.controller;
import com.techup.spring_demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/register")
    public String register(@Valid @RequestBody Map<String, String> requestBody) {
        return authService.register(requestBody.get("name"), requestBody.get("email"), requestBody.get("password"));
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody Map<String, String> requestBody) {
        return authService.login(requestBody.get("email"), requestBody.get("password"));
    }
}
