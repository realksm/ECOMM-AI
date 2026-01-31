package com.ksm.ecommerce.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Embeddable
public class CartItem {
    @NotNull
    private Long productId;
    @Min(1)
    private Integer quantity;
}