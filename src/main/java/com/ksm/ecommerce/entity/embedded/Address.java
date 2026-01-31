package com.ksm.ecommerce.entity.embedded;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Address {
    @NotBlank
    private String line1;
    private String line2;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String postalCode;
    @NotBlank
    private String country;
}
