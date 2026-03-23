package com.demo.awssqsconsumer.dto;

import lombok.*;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {

    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
    private Double totalAmount;

}
