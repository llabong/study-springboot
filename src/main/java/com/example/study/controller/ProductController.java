package com.example.study.controller;

import com.example.study.Service.ProductService;
import com.example.study.dto.ProductMessageResponseDto;
import com.example.study.dto.ProductRequestDto;
import com.example.study.dto.ProductResponseDto;
import com.example.study.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product =  productService.getProductById(id);

        if (product == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(product);
        }
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProduts();
    }

    @PutMapping("/{id}")
    public ProductMessageResponseDto updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ProductMessageResponseDto deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
