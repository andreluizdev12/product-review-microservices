package com.github.andreluizdev12.product_with_spring.config.FeignConfig;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ReviewAdapter {
    private final ReviewProxy reviewProxy;


    public ReviewAdapter(ReviewProxy reviewProxy) {
        this.reviewProxy = reviewProxy;
    }

    @CircuitBreaker(
            name = "review-service"
//            fallbackMethod = "fallback"
    )
    public List<ReviewDto> getReviews (Long id) {
        return reviewProxy.getReviews(id);
    }

    public List<ReviewDto> fallback(Long id,  Throwable ex){
        return List.of();
    }

}
