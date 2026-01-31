package com.ksm.ecommerce.service;

import com.ksm.ecommerce.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getOrdersForUser(Long userId);
    Order updateStatus(Long orderId, String status);
}