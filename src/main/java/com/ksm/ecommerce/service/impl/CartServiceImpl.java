package com.ksm.ecommerce.service.impl;

import com.ksm.ecommerce.entity.Cart;
import com.ksm.ecommerce.entity.embedded.CartItem;
import com.ksm.ecommerce.repo.CartRepository;
import com.ksm.ecommerce.service.CartService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public Cart getCart(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> cartRepository.save(
                                Cart.builder()
                                    .userId(userId)
                                    .items(new ArrayList<>())
                                    .build()
                ));
    }

    @Override
    public Cart addItem(Long userId, Long productId, int quantity) {
        Cart cart = getCart(userId);
        cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst()
                .ifPresentOrElse(
                        item -> item.setQuantity(item.getQuantity() + quantity),
                        () -> cart.getItems().add(
                                CartItem.builder()
                                        .productId(productId)
                                        .quantity(quantity)
                                        .build()
                        )
                );
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateItem(Long userId, Long productId, int quantity) {
        Cart cart = getCart(userId);

        cart.getItems().removeIf(item -> {
            if(item.getProductId().equals(productId)) {
                if(quantity <= 0) return true;
                item.setQuantity(quantity);
            }
            return false;
        });

        return cartRepository.save(cart);
    }

    @Override
    public Cart removeItem(Long userId, Long productId) {
        Cart cart = getCart(userId);

        cart.getItems().removeIf(item ->
                item.getProductId().equals(productId)
        );

        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(Long userId) {
        Cart cart = getCart(userId);
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
