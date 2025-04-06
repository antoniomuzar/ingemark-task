package com.example.ingemark_task.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ingemark_task.dto.ProductDTO;
import com.example.ingemark_task.mapper.ProductMapper;
import com.example.ingemark_task.model.Product;
import com.example.ingemark_task.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ExchangeRateService exchangeRateService;

    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ExchangeRateService exchangeRateService, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.exchangeRateService = exchangeRateService;
        this.productMapper = productMapper;
    }

    /**
     * @param productDTO the product to be saved
     *
     * @return the saved product as a DTO
     */

    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product.setPriceUsd(exchangeRateService.convertToUsd(product.getPriceEur()));
        Product savedProduct = productRepository.save(product);
        return productMapper.toDTO(savedProduct);
    }

    /**
     * @return a product by its ID and returns it as a DTO
     */

    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id)
                                .map(productMapper::toDTO);
    }

    /**
     * @return a list of all product DTOs
     */
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                                .stream()
                                .map(productMapper::toDTO)
                                .toList();
    }

}
