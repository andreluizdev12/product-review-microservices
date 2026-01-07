package com.github.andreluizdev12.product_with_spring.service;

import com.github.andreluizdev12.product_with_spring.Domain.*;
import com.github.andreluizdev12.product_with_spring.config.FeignConfig.ReviewAdapter;
import com.github.andreluizdev12.product_with_spring.config.FeignConfig.ReviewDto;
import com.github.andreluizdev12.product_with_spring.config.FeignConfig.ReviewProxy;
import com.github.andreluizdev12.product_with_spring.repository.ProductRepository;
import jakarta.persistence.Cache;
import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@Service
public class ProductService {
    Logger logger = LoggerFactory.getLogger(ProductService.class);
    private final ReviewAdapter reviewAdapter;

    private final ProductRepository productRepository;

    private  Map<Long ,List<ReviewDto>> CACHE = new HashMap<>();

    public ProductResponseDetailsDTO getProductById (Long id){
        logger.debug("Searching product");

       var product = productRepository.findById(id).
               orElseThrow(( ) -> new EntityNotFoundException("Product with id: "+ id + " not found"));
        logger.debug("Searching reviews of product");

        var reviews = reviewAdapter.getReviews(product.getId());
        logger.debug("feeding cache");
        CACHE.put(id,reviews);
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
