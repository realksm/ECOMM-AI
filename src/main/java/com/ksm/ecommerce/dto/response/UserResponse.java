package com.ksm.ecommerce.dto.response;

import com.ksm.ecommerce.dto.common.AddressDTO;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class UserResponse {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private List<AddressDTO> addresses;
    private Instant createdAt;
}
