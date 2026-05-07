package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.auth.AuthResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.auth.LoginRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.auth.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest signupRequest);
    AuthResponse login(LoginRequest loginRequest);

}
