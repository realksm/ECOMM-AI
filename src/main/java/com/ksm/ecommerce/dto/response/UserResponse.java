package com.ksm.ecommerce.dto.response;

import com.ksm.ecommerce.entity.embedded.Address;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private List<Address> addresses;
    private Instant createdAt;
}
