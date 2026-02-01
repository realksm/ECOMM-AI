package com.ksm.ecommerce.repo;

import com.ksm.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<User> findByFirstNameIgnoreCase(String firstName);
    List<User> findByLastNameIgnoreCase(String lastName);
    List<User> findByEmailContainingIgnoreCase(String keyword);
    Optional<User> findByPhone(String phone);
}
