package com.ksm.ecommerce.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Embeddable
public class OrderItem {
    @NotNull
    private Long productId;
    @NotNull
    private String productName;
    @NotNull
    private BigDecimal price;
    @Min(1)
    private Integer quantity;
}