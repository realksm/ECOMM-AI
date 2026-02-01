package com.ksm.ecommerce.dto.common;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDTO {

    @NotNull
    private Long productId;

    private String productName;

    @NotNull
    private BigDecimal price;

    @Min(1)
    private Integer quantity;
}