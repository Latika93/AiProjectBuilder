package com.aiProjectBuilder.aiProjectBuilder.controller;

import com.aiProjectBuilder.aiProjectBuilder.dto.auth.AuthResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.auth.LoginRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.auth.SignupRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.auth.UserProfileResponse;
import com.aiProjectBuilder.aiProjectBuilder.service.AuthService;
import com.aiProjectBuilder.aiProjectBuilder.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {
    UserService userService;
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest signupRequest){
        return ResponseEntity.ok(authService.signup(signupRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile(){
        Long userId = 1L;
        return ResponseEntity.ok(userService.getProfile());
    }
}
