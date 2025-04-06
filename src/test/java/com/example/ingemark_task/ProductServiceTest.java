package com.example.ingemark_task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ingemark_task.dto.ProductDTO;
import com.example.ingemark_task.mapper.ProductMapper;
import com.example.ingemark_task.model.Product;
import com.example.ingemark_task.repository.ProductRepository;
import com.example.ingemark_task.service.ExchangeRateService;
import com.example.ingemark_task.service.ProductService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    ExchangeRateService exchangeRateService;

    @Mock
    private ProductMapper productMapper;

    @Test
    public void testSaveProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode("HNB1234567");
        productDTO.setPriceEur(100.00);

        when(exchangeRateService.convertToUsd(anyDouble())).thenReturn(108.03);
        when(productRepository.save(any(Product.class))).thenReturn(new Product());

        when(productMapper.toEntity(any(ProductDTO.class))).thenReturn(new Product());
        when(productMapper.toDTO(any(Product.class))).thenReturn(productDTO);

        ProductDTO savedProduct = productService.saveProduct(productDTO);

        assertNotNull(savedProduct);
        assertEquals("HNB1234567", savedProduct.getCode());
    }

}
