package com.ksm.ecommerce.service.impl;

import com.ksm.ecommerce.dto.request.LoginRequest;
import com.ksm.ecommerce.dto.request.RegisterRequest;
import com.ksm.ecommerce.dto.response.AuthResponse;
import com.ksm.ecommerce.entity.AuthIdentity;
import com.ksm.ecommerce.entity.AuthProvider;
import com.ksm.ecommerce.entity.User;
import com.ksm.ecommerce.repo.AuthIdentityRepository;
import com.ksm.ecommerce.repo.UserRepository;
import com.ksm.ecommerce.security.JwtUtil;
import com.ksm.ecommerce.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final AuthIdentityRepository authIdentityRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .build();

        user = userRepository.save(user);

        AuthIdentity auth = AuthIdentity.builder()
                .provider(AuthProvider.LOCAL)
                .identifier(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .userId(user.getId())
                .build();

        authIdentityRepository.save(auth);

        String token = jwtUtil.generateToken(user.getId(), user.getEmail());

        return AuthResponse.builder()
                .userId(user.getId())
                .accessToken(token)
                .build();
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        AuthIdentity authIdentity = authIdentityRepository.findByProviderAndIdentifier(
                AuthProvider.LOCAL,
                loginRequest.getEmail()
        ).orElseThrow(() -> new RuntimeException("invalid credentials"));

        if(!authIdentity.isEnabled()) {
            throw new RuntimeException("Account disabled");
        }

        if(!passwordEncoder.matches(
                loginRequest.getPassword(),
                authIdentity.getPasswordHash())) {
            throw new RuntimeException("invalid credentials");
        }

        String token = jwtUtil.generateToken(authIdentity.getUserId(), loginRequest.getEmail());

        return AuthResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .userId(authIdentity.getUserId())
                .build();
    }
}
