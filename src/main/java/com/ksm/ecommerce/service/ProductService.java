package com.ksm.ecommerce.service;

import com.ksm.ecommerce.dto.ProductDTO;
import com.ksm.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);
    ProductDTO getById(Long productId);
    List<ProductDTO> search(String keyword);
    List<ProductDTO> getByCategory(String category);
    ProductDTO update(Long productId, ProductDTO productDTO);
    void delete(Long productId);
}
