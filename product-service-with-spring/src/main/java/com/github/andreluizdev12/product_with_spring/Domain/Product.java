package com.github.andreluizdev12.product_with_spring.Domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   private String code;
   private String name;
   @Enumerated(EnumType.STRING)
   private Category category;
   private BigDecimal price;

   private Product(String name, BigDecimal price, Category category) {
      this.name = name;
      this.price = price;
      this.category = category;
   }

   public static Product create(String name, Category category, BigDecimal price) {
      return new Product(name, price, category);
   }

   @PostPersist
   private void generateCodigo() {
      this.code = name.substring(0, 3).toUpperCase() + id;
   }
}
