package com.ksm.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Table(
    name = "auth_identities",
    uniqueConstraints = {
        @UniqueConstraint(
            name = "pk_provider_identifier",
            columnNames = {"provider", "identifier"}
        )
    },
    indexes = {
        @Index(name = "idx_auth_user", columnList = "user_id")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthIdentity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuthProvider provider;

    /*
    * Email for LOCAL
    * Google "sub" for GOOGLE
    */
    @NotBlank
    @Column(nullable = false)
    private String identifier;

    /*
    *Only for LOCAL provider
    */
    private String passwordHash;

    @Builder.Default
    @Column(nullable = false)
    private boolean enabled = true;
}
