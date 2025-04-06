package com.example.ingemark_task.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.ingemark_task.dto.ProductDTO;
import com.example.ingemark_task.model.Product;

@Component
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO toDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product toEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }
}
