package com.aiProjectBuilder.aiProjectBuilder.service;

import com.aiProjectBuilder.aiProjectBuilder.dto.AuthResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.LoginRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.SignupRequest;

public interface AuthService {
    AuthResponse signup(SignupRequest signupRequest);
    AuthResponse login(LoginRequest loginRequest);

}
