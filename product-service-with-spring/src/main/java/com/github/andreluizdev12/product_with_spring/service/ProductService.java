package com.github.andreluizdev12.product_with_spring.service;

import com.github.andreluizdev12.product_with_spring.Domain.*;
import com.github.andreluizdev12.product_with_spring.config.FeignConfig.ReviewProxy;
import com.github.andreluizdev12.product_with_spring.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;



@RequiredArgsConstructor
@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ReviewProxy reviewProxy;
    private final ProductRepository productRepository;


    public ProductResponseDetailsDTO getProductById (Long id){
        logger.debug("Searching product");
       var product = productRepository.findById(id).
               orElseThrow(( ) -> new EntityNotFoundException("Product with id: "+ id + " not found"));
        logger.debug("Searching reviews of product");
        var reviews = reviewProxy.getReviews(product.getId());
        logger.debug(reviews.toString());
        return  new ProductResponseDetailsDTO(product.getId(),product.getCode(),product.getName(),product.getCategory(),product.getPrice(),reviews);
    }

    public Product createProduct(ProductCreateDTO productCreateDTO) {

        if(productRepository.existsByName(productCreateDTO.name()))
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Product with name " + productCreateDTO.name() + " already exists"
            );

        var product = Product.create(productCreateDTO.name(),productCreateDTO.category(),productCreateDTO.price());
        return productRepository.save(product);

    }


    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }
}
