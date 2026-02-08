package com.ksm.ecommerce.mapper;

import com.ksm.ecommerce.dto.request.UserCreateRequest;
import com.ksm.ecommerce.dto.request.UserUpdateRequest;
import com.ksm.ecommerce.dto.response.UserResponse;
import com.ksm.ecommerce.entity.User;

import java.util.ArrayList;

public class UserMapper {

    private UserMapper() {}

    public static User toEntity(UserCreateRequest request) {
        return User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .addresses(
                        request.getAddresses() != null
                                ? request.getAddresses()
                                : new ArrayList<>()
                )
                .build();
    }

    public static User toEntity(UserUpdateRequest request) {
        return User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phone(request.getPhone())
                .addresses(
                        request.getAddresses() != null
                                ? request.getAddresses()
                                : new ArrayList<>()
                )
                .build();
    }

    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .addresses(user.getAddresses())
                .createdAt(user.getCreatedAt())
                .build();
    }
}
