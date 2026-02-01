package com.ksm.ecommerce.dto.request;

import com.ksm.ecommerce.dto.common.AddressDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Data
public class UserRegisterRequest {
    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10,15}$")
    private String phoneNumber;

    private List<AddressDTO> addresses;
}
