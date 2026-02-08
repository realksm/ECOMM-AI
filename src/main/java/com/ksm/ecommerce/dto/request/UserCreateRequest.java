package com.ksm.ecommerce.dto.request;

import com.ksm.ecommerce.entity.embedded.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class UserCreateRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10,15}$")
    private String phone;

    private List<Address> addresses;
}
