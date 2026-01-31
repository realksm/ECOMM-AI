package com.ksm.ecommerce.service;

import com.ksm.ecommerce.entity.User;

public interface UserService {
    User register(User user);
    User getById(Long id);
    User getByEmail(String email);
}
