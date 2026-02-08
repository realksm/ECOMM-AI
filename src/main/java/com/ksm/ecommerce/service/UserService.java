package com.ksm.ecommerce.service;

import com.ksm.ecommerce.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User getById(Long id);
    User getByEmail(String email);
    List<User> searchByEmail(String email);
    List<User> searchByName(String name);
    User updateProfile(Long userId, User updatedUser);
    void changePassword(Long userId, String oldPassword, String newPassword);
    void delete(Long userId);
}
