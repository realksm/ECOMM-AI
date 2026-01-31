package com.ksm.ecommerce.service;

import com.ksm.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product getById(Long productId);
    List<Product> search(String keyword);
    List<Product> getByCategory(String category);
}
