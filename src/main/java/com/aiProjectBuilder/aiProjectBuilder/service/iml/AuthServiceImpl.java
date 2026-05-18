package com.aiProjectBuilder.aiProjectBuilder.service.iml;

import com.aiProjectBuilder.aiProjectBuilder.dto.auth.AuthResponse;
import com.aiProjectBuilder.aiProjectBuilder.dto.auth.LoginRequest;
import com.aiProjectBuilder.aiProjectBuilder.dto.auth.SignupRequest;
import com.aiProjectBuilder.aiProjectBuilder.entity.User;
import com.aiProjectBuilder.aiProjectBuilder.errors.BadRequestException;
import com.aiProjectBuilder.aiProjectBuilder.mapper.UserMapper;
import com.aiProjectBuilder.aiProjectBuilder.repository.UserRepository;
import com.aiProjectBuilder.aiProjectBuilder.service.AuthService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username()).ifPresent(user -> {
            throw new BadRequestException("User already exists with username: "+request.username());
        });

        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user = userRepository.save(user);

        return new AuthResponse("dummy", userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
