package com.example.study.dto;

import lombok.Getter;
import lombok.Setter;

public class ProductResponseDto {
    @Getter
    private Long id;
    @Setter
    @Getter
    private String name;

    public ProductResponseDto() {}

    public ProductResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
