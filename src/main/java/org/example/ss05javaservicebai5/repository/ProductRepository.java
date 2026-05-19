package org.example.ss05javaservicebai5.repository;

import org.example.ss05javaservicebai5.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}