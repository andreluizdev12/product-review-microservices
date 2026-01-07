package com.github.andreluizdev12.product_with_spring.Domain;

import java.math.BigDecimal;

public record ProductResponseDTO
        (
            Long id ,
            String code,
            String name,
            Category category,
            BigDecimal price

        ){
    public ProductResponseDTO(Product prd) {
        this(prd.getId() ,prd.getCode(),
                prd.getName(),prd.getCategory(),prd.getPrice());
    }
}

