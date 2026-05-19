package org.example.ss05javaservicebai5.service.impl;


import org.example.ss05javaservicebai5.model.dto.ProductDTO;
import org.example.ss05javaservicebai5.model.entity.Product;
import org.example.ss05javaservicebai5.repository.ProductRepository;
import org.example.ss05javaservicebai5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy sản phẩm có ID: " + id));
    }

    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(productDTO.getName());
        existingProduct.setPrice(productDTO.getPrice());
        return productRepository.save(existingProduct);
    }

    @Override
    public Product patchProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = getProductById(id);
        
        // Chỉ cập nhật trường nào được gửi lên (khác null hoặc không trống)
        if (productDTO.getName() != null && !productDTO.getName().trim().isEmpty()) {
            existingProduct.setName(productDTO.getName());
        }
        if (productDTO.getPrice() != null) {
            existingProduct.setPrice(productDTO.getPrice());
        }
        
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product existingProduct = getProductById(id);
        productRepository.delete(existingProduct);
    }
}