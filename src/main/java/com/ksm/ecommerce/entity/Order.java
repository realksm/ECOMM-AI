package com.ksm.ecommerce.entity;
import com.ksm.ecommerce.entity.embedded.Address;
import com.ksm.ecommerce.entity.embedded.OrderItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(
        name = "orders",
        indexes = {
                @Index(name = "idx_orders_user", columnList = "user_id")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @ElementCollection
    @CollectionTable(name = "order_items")
    private List<OrderItem> items;

    private BigDecimal totalAmount;

    @NotNull
    private String status;

    @Embedded
    private Address shippingAddress;

    @Embedded
    private Address billingAddress;

    private String paymentId;
}
