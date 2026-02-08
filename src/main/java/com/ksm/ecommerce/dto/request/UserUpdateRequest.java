package com.ksm.ecommerce.dto.request;

import com.ksm.ecommerce.dto.common.AddressDTO;
import com.ksm.ecommerce.entity.embedded.Address;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class UserUpdateRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String phone;

private List<Address> addresses;
}
