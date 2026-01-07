package com.github.andreluizdev12.product_with_spring.repository;

import com.github.andreluizdev12.product_with_spring.Domain.Product;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ProductRepository extends JpaRepository<Product,Long> {
    boolean existsByName(String name);
}
