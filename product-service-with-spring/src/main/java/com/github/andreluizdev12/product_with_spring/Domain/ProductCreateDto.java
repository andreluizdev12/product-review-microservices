package com.github.andreluizdev12.product_with_spring.Domain;


import java.math.BigDecimal;

public record ProductCreateDto(
         String name,
         Category category,
         BigDecimal price,
         Long count
) {
}
