package com.ksm.ecommerce.service.impl;

import com.ksm.ecommerce.entity.Product;
import com.ksm.ecommerce.repo.ProductRepository;
import com.ksm.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ksm.ecommerce.dto.ProductDTO;
import com.ksm.ecommerce.dto.ProductDTO;


import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public ProductDTO create(ProductDTO productDTO) {
        Product product = toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return toDTO(savedProduct);
    }

    @Override
    public ProductDTO getById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));
        return toDTO(product);
    }

    @Override
    public List<ProductDTO> search(String keyword) {
        return productRepository.findByNameContainingIgnoreCase(keyword).stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public List<ProductDTO> getByCategory(String category) {
        return productRepository.findByCategory(category).stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public ProductDTO update(Long productId, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        existingProduct.setName(productDTO.getProductName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(BigDecimal.valueOf(productDTO.getPrice()));
        existingProduct.setStock(productDTO.getQuantity());
        // Map first image back to list
        existingProduct.setImages(List.of(productDTO.getImage()));

        Product updatedProduct = productRepository.save(existingProduct);
        return toDTO(updatedProduct);
    }

    @Override
    @Transactional
    public void delete(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product not found: " + productId);
        }
        productRepository.deleteById(productId);
    }

    // --- Helper Mapping Methods ---

    private ProductDTO toDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getId());
        dto.setProductName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setQuantity(product.getStock());
        dto.setPrice(product.getPrice().doubleValue());
        // Handling the list of images for the single string DTO field
        dto.setImage(product.getImages() != null && !product.getImages().isEmpty()
                ? product.getImages().get(0) : null);

        // Note: Discount/SpecialPrice logic can be added here if fields exist in Entity
        return dto;
    }

    private Product toEntity(ProductDTO dto) {
        return Product.builder()
                .name(dto.getProductName())
                .description(dto.getDescription())
                .price(BigDecimal.valueOf(dto.getPrice()))
                .stock(dto.getQuantity())
                .images(List.of(dto.getImage()))
                .category("Default") // Adjust based on your logic
                .build();
    }
}