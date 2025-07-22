package com.example.study.dto;

public class ProductMessageResponseDto {
    private String message;

    ProductMessageResponseDto() {}

    public ProductMessageResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
