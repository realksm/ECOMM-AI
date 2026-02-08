package com.ksm.ecommerce.service.impl;

import com.ksm.ecommerce.entity.Product;
import com.ksm.ecommerce.repo.ProductRepository;
import com.ksm.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> search(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getByCategory(String category) {
        return productRepository.findByCategory(category);
    }
    @Override
    @Transactional
    public Product update(Long productId, Product productDetails) {
        Product existingProduct = getById(productId); // Reuses existing check logic

        existingProduct.setName(productDetails.getName());
        existingProduct.setDescription(productDetails.getDescription());
        existingProduct.setPrice(productDetails.getPrice());
        existingProduct.setCategory(productDetails.getCategory());
        existingProduct.setSubcategory(productDetails.getSubcategory());
        existingProduct.setStock(productDetails.getStock());
        existingProduct.setImages(productDetails.getImages());
        existingProduct.setTags(productDetails.getTags());

        return productRepository.save(existingProduct);
    }

    @Override
    @Transactional
    public void delete(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Cannot delete. Product not found: " + productId);
        }
        productRepository.deleteById(productId);
    }
}