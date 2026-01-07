package com.github.andreluizdev12.product_with_spring.Domain;

import com.github.andreluizdev12.product_with_spring.config.FeignConfig.ReviewDto;

import java.math.BigDecimal;
import java.util.List;

public record ProductResponseDetailsDTO(
        Long id ,
        String code,
        String name,
        Category category,
        BigDecimal price,
        List<ReviewDto> reviews

) {

}
