package com.github.andreluizdev12.product_with_spring.controller;

import com.github.andreluizdev12.product_with_spring.Domain.ProductCreateDTO;
import com.github.andreluizdev12.product_with_spring.Domain.ProductResponseDTO;
import com.github.andreluizdev12.product_with_spring.Domain.ProductResponseDetailsDTO;
import com.github.andreluizdev12.product_with_spring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping( "/get/{id}")
    public ProductResponseDetailsDTO getProductById(@PathVariable  Long id){
     return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts(){
        return productService.getAllProducts().stream().map(ProductResponseDTO ::new).toList();

    }

   @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        return new ProductResponseDTO(productService.createProduct(productCreateDTO));

    }


}
