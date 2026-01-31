package com.ksm.ecommerce.repo;

import com.ksm.ecommerce.entity.User;
import com.ksm.ecommerce.entity.embedded.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
