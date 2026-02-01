package com.ksm.ecommerce.mapper;

import com.ksm.ecommerce.dto.request.UserRegisterRequest;
import com.ksm.ecommerce.dto.request.UserUpdateRequest;
import com.ksm.ecommerce.dto.response.UserResponse;
import com.ksm.ecommerce.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CommonMapper.class)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(
            target = "addresses",
            defaultExpression = "java(new ArrayList<>()"
    )
    User toEntity(UserRegisterRequest request);

    @Mapping(target = "id", ignore = true)
    User toEntity(UserUpdateRequest request);

    UserResponse toResponse(User user);
}
