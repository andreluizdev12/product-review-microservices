package com.github.andreluizdev12.product_with_spring.config.FeignConfig;

public record ReviewDto(

        Long id,
        Integer rating,
        String comment,
        String measurerName,
        Long productId

) {



}


