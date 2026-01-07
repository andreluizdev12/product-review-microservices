package com.github.andreluizdev12.review_with_spring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer rating;
    @Column(length = 1000)
    private String comment;
    private String measurerName;
    private Long productId;

    private Review(Integer rating, Long productId, String measurerName, String comment) {
        this.rating = rating;
        this.productId = productId;
        this.measurerName = measurerName;
        this.comment = comment;
    }

    public static Review create(Integer rating, Long productId, String measurerName, String comment){
        return  new Review(rating,productId,measurerName,comment);
    }
}
