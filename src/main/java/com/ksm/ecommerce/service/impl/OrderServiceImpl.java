package com.ksm.ecommerce.service.impl;

import com.ksm.ecommerce.dto.OrderDTO;
import com.ksm.ecommerce.dto.OrderResponse;
import com.ksm.ecommerce.repo.*;
import com.ksm.ecommerce.service.OrderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductRepository productRepository;


    @Override
    @Transactional
    public OrderDTO placeOrder(String emailId, Long addressId, String paymentMethod, String pgName, String pgPaymentId, String pgStatus, String pgResponseMessage) {
        OrderDTO order=new OrderDTO();
        return order;
    }

    @Override
    public OrderResponse getAllOrders(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        OrderResponse orderResponse = new OrderResponse();
        return orderResponse;
    }

    @Override
    public OrderDTO updateOrder(Long orderId, String status) {
        OrderDTO order=new OrderDTO();
        return order;
    }

    @Override
    public OrderResponse getAllSellerOrders(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {
        OrderResponse orderResponse = new OrderResponse();
        return orderResponse;
    }


}
