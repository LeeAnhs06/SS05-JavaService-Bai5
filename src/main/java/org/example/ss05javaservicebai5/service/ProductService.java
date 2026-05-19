package org.example.ss05javaservicebai5.service;

import org.example.ss05javaservicebai5.model.dto.ProductDTO;
import org.example.ss05javaservicebai5.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(ProductDTO productDTO);
    Product updateProduct(Long id, ProductDTO productDTO);
    Product patchProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
}