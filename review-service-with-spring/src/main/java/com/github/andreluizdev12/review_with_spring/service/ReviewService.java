package com.github.andreluizdev12.review_with_spring.service;

import com.github.andreluizdev12.review_with_spring.domain.Review;
import com.github.andreluizdev12.review_with_spring.domain.ReviewCreateDTO;
import com.github.andreluizdev12.review_with_spring.domain.ReviewResponseDTO;
import com.github.andreluizdev12.review_with_spring.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getReviewsByProductId( Long id){
        return reviewRepository.findAllByProductId(id);
    }
    public Review createReview(ReviewCreateDTO dto){
       var response =   reviewRepository.save(
                Review.create(dto.rating(),dto.productId(), dto.measurerName(), dto.comment())
        );
        System.out.println(response);
       return  response;
//        return  reviewRepository.save(
//                 Review.create(dto.rating(),dto.productId(), dto.measurerName(), dto.comment())
//        );
    }


}
