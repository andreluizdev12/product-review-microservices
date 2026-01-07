package com.github.andreluizdev12.review_with_spring.domain;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public record ReviewCreateDTO(
        @NotNull @Min(1) @Max(5) Integer rating,
        @Size(max = 1000) String comment,
        @NotBlank String measurerName,
        @NotNull Long productId
){
}
