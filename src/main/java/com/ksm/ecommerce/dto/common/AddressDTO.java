package com.ksm.ecommerce.dto.common;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {
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
