package com.ksm.ecommerce.controller;

import com.ksm.ecommerce.dto.request.ChangePasswordRequest;
import com.ksm.ecommerce.dto.request.UserCreateRequest;
import com.ksm.ecommerce.dto.request.UserUpdateRequest;
import com.ksm.ecommerce.dto.response.UserResponse;
import com.ksm.ecommerce.entity.User;
import com.ksm.ecommerce.mapper.UserMapper;
import com.ksm.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserMapper.toResponse(
                        userService.create(
                                UserMapper.toEntity(request)
                                )
                        )
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(
                UserMapper.toResponse(
                        userService.getById(id)
                )
        );
    }

    @GetMapping("/email")
    public ResponseEntity<UserResponse> getByEmail(@RequestParam String email) {
        return ResponseEntity.ok(
                UserMapper.toResponse(
                        userService.getByEmail(email)
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateProfile(
            @PathVariable Long id,
            @Valid @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(
                UserMapper.toResponse(
                        userService.updateProfile(
                                id, UserMapper.toEntity(request)
                        )
                )
        );
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> changePassword(
            @PathVariable Long id,
            @Valid @RequestBody ChangePasswordRequest request) {
        userService.changePassword(
                id,
                request.getOldPassword(),
                request.getNewPassword()
        );

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id) {

//        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.of(Optional.ofNullable(userService.searchByEmail("john")));
    }
}
