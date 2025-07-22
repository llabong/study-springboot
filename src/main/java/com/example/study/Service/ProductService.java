package com.example.study.Service;

import com.example.study.dto.ProductMessageResponseDto;
import com.example.study.dto.ProductRequestDto;
import com.example.study.dto.ProductResponseDto;
import com.example.study.entity.Product;
import com.example.study.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//     상품 생성
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setName(productRequestDto.getName());

        Product savedProduct = productRepository.save(product);

        return new ProductResponseDto(savedProduct.getId(), savedProduct.getName());
    }

//     하나의 상품 조회
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 상품이 없습니다."));
    }

//     모든 상품 조회
    public List<Product> getAllProduts() {
        return productRepository.findAll();
    }

//     상품 수정
    public ProductMessageResponseDto updateProduct(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            productRepository.save(existingProduct);

            return new ProductMessageResponseDto("상품이 수정되었습니다.");
        } else {
            throw new IllegalArgumentException("해당 상품이 없습니다.");
        }
    }

//     상품 삭제
    public ProductMessageResponseDto deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            productRepository.deleteById(id);

            return new ProductMessageResponseDto("상품이 삭제되었습니다.");
        } else {
            throw new IllegalArgumentException("해당 상품이 없습니다.");
        }
    }
}
