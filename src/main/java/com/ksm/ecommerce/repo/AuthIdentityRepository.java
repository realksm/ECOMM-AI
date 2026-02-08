package com.ksm.ecommerce.repo;

import com.ksm.ecommerce.entity.AuthIdentity;
import com.ksm.ecommerce.entity.AuthProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthIdentityRepository extends JpaRepository<AuthIdentity, Long> {
    Optional<AuthIdentity> findByProviderAndIdentifier(AuthProvider provider, String identifier);
}
