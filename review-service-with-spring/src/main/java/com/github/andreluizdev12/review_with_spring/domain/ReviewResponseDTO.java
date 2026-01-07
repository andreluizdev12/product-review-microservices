package com.github.andreluizdev12.review_with_spring.domain;

public record ReviewResponseDTO(

         Long id,
         Integer rating,
         String comment,
         String measurerName,
         Long productId


) {
    public ReviewResponseDTO(Review review) {
       this(
          review.getId(),
          review.getRating(),
          review.getComment(),
          review.getMeasurerName(),
          review.getProductId());
    }


}
