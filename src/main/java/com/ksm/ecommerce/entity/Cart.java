package com.ksm.ecommerce.entity;

import com.ksm.ecommerce.entity.embedded.CartItem;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(
    name = "cart",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ElementCollection
    @CollectionTable(name = "cart_items")
    private List<CartItem> items;
}