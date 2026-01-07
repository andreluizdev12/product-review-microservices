package com.github.andreluizdev12.product_with_spring.config.FeignConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "review-service",url = "http://localhost:8100")
public interface ReviewProxy {
    @GetMapping(value = "/api/reviews/get/{id}")
    public List<ReviewDto> getReviews(@PathVariable Long  id);
}
