package com.ksm.ecommerce.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(
    name = "products",
    indexes = {
        @Index(name = "idx_products_name", columnList = "name"),
        @Index(name = "idx_products_category", columnList = "category")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotBlank
    private String category;

    private String subcategory;

    @ElementCollection
    private List<String> images;

    @Min(0)
    private Integer stock;

    @ElementCollection
    private List<String> tags;

    private BigDecimal rating;

    private Integer reviewCount;
}
