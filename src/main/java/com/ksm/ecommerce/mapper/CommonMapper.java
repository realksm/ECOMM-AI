package com.ksm.ecommerce.mapper;

import com.ksm.ecommerce.dto.common.AddressDTO;
import com.ksm.ecommerce.dto.common.CartItemDTO;
import com.ksm.ecommerce.dto.common.OrderItemDTO;
import com.ksm.ecommerce.entity.embedded.Address;
import com.ksm.ecommerce.entity.embedded.CartItem;
import com.ksm.ecommerce.entity.embedded.OrderItem;

public interface CommonMapper {
    Address toEntity(AddressDTO dto);
    AddressDTO toDTO(Address entity);

    OrderItem toEntity(OrderItemDTO dto);
    OrderItemDTO toDto(OrderItem entity);

    CartItem toEntity(CartItemDTO dto);
    CartItemDTO toDto(CartItem entity);

}
