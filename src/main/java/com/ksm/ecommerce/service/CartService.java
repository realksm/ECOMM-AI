package com.ksm.ecommerce.service;

import com.ksm.ecommerce.entity.Cart;

public interface CartService {
    Cart getCart(Long userId);
    Cart addItem(Long userId, Long productId, int quantity);
    Cart removeItem(Long userId, Long productId);
}