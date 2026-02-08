package com.ksm.ecommerce.controller;

import com.ksm.ecommerce.entity.Cart;
import com.ksm.ecommerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    private Long currentUserId() {
        return (Long) Objects.requireNonNull(SecurityContextHolder
                        .getContext()
                        .getAuthentication())
                .getPrincipal();
    }

    @GetMapping
    public Cart getCart() {
        return cartService.getCart(currentUserId());
    }

    @PostMapping("/items")
    public Cart addItem(
            @RequestParam Long productId,
            @RequestParam int quantity
    ) {
        return cartService.addItem(currentUserId(), productId, quantity);
    }

    @PutMapping("/items/{productId}")
    public Cart updateItem(
            @PathVariable Long productId,
            @RequestParam int quantity
    ) {
        return cartService.updateItem(currentUserId(), productId, quantity);
    }

    @DeleteMapping("/items/{productId}")
    public Cart removeItem(@PathVariable Long productId) {
        return cartService.removeItem(currentUserId(), productId);
    }

    @DeleteMapping
    public void clearCart() {
        cartService.clearCart(currentUserId());
    }
}