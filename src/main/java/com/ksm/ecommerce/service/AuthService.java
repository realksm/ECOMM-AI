package com.ksm.ecommerce.service;

import com.ksm.ecommerce.dto.request.LoginRequest;
import com.ksm.ecommerce.dto.request.RegisterRequest;
import com.ksm.ecommerce.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse login(LoginRequest loginRequest);
}
