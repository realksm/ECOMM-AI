package com.ksm.ecommerce.mapper;

import com.ksm.ecommerce.dto.common.AddressDTO;
import com.ksm.ecommerce.entity.embedded.Address;
import com.ksm.ecommerce.entity.embedded.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommonMapper {
    Address toEntity(AddressDTO dto);
    AddressDTO toDTO(Address entity);

    OrderItem toEntity(OrderItemDTO dto);
    OrderItemDTO toDto(OrderItem entity);

    CartItem toEntity(CartItemDTO dto);
    CartItemDTO toDto(CartItem entity);

}
