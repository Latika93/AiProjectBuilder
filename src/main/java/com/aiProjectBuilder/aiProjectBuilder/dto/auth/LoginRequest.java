package com.aiProjectBuilder.aiProjectBuilder.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
