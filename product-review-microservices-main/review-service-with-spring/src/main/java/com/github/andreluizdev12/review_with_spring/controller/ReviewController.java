package com.github.andreluizdev12.review_with_spring.controller;


import com.github.andreluizdev12.review_with_spring.domain.Review;
import com.github.andreluizdev12.review_with_spring.domain.ReviewCreateDTO;
import com.github.andreluizdev12.review_with_spring.domain.ReviewResponseDTO;
import com.github.andreluizdev12.review_with_spring.repository.ReviewRepository;
import com.github.andreluizdev12.review_with_spring.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reviews")
  public  class ReviewController{
    private final ReviewService reviewService;

      @GetMapping("/get/{id}")
    public List<ReviewResponseDTO> getReviewsByProductId(@PathVariable Long id){
         return reviewService.getReviewsByProductId(id)
                 .stream().map(ReviewResponseDTO::new).toList();
    }
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ReviewResponseDTO createReview(
          @RequestBody @Valid ReviewCreateDTO dto
  ) {
    Review review = reviewService.createReview(dto);
    return new ReviewResponseDTO(review);
  }
}
