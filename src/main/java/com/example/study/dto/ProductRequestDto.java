package com.example.study.dto;

import com.example.study.repository.ProductRepository;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequestDto {
    private String name;

    public ProductRequestDto() {}

    public ProductRequestDto(String name) {
        this.name = name;
    }

}
