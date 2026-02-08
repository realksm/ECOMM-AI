package com.ksm.ecommerce.service.impl;

import com.ksm.ecommerce.entity.User;
import com.ksm.ecommerce.repo.UserRepository;
import com.ksm.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    // TODO : add Password Encoder after adding Spring Security

    @Override
    public User create(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> searchByEmail(String keyword) {
        return userRepository.findByEmailContainingIgnoreCase(keyword);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> searchByName(String name) {
        List<User> byFirst = userRepository.findByFirstNameIgnoreCase(name);
        List<User> byLast = userRepository.findByLastNameIgnoreCase(name);
        byFirst.addAll(byLast);
        return byFirst;
    }

    @Override
    public User updateProfile(Long userId, User updatedUser) {
        User existingUser = getById(userId);

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setPhone(updatedUser.getPhone());
        existingUser.setAddresses(updatedUser.getAddresses());

        return userRepository.save(existingUser);
    }

    @Override
    public void changePassword(Long userId, String oldPassword, String newPassword) {

    }

    @Override
    public void delete(Long userId) {
        User user = getById(userId);
        userRepository.delete(user);
    }
}
