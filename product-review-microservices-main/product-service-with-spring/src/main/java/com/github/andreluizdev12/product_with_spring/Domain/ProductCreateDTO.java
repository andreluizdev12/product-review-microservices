package com.github.andreluizdev12.product_with_spring.Domain;


import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductCreateDTO(
         @NotBlank
         String name,
         @NotBlank
         Category category,
         @NotBlank
         BigDecimal price

) {
}
