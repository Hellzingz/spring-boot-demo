package com.techup.spring_demo.dto;
    
import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Double price;
    private String description;
}

