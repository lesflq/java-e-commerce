package org.example.lab1.controllers;

import org.example.lab1.DTO.ProductDTO;
import org.example.lab1.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Test
    void testCreateProduct() {
        ProductDTO productDTO = new ProductDTO(); // Заповни дані продукту
        ProductDTO createdProduct = new ProductDTO(); // Заповни дані створеного продукту

        when(productService.createProduct(any(ProductDTO.class))).thenReturn(createdProduct);

        ResponseEntity<ProductDTO> response = productController.createProduct(productDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdProduct, response.getBody());
        verify(productService, times(1)).createProduct(productDTO);
    }

    @Test
    void testGetAllProducts() {
        List<ProductDTO> productList = new ArrayList<>(); // Заповни даними продуктів

        when(productService.getAllProducts()).thenReturn(productList);

        ResponseEntity<List<ProductDTO>> response = productController.getAllProducts();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(productList, response.getBody());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    void testGetProductById() {
        Long productId = 1L;
        ProductDTO product = new ProductDTO(); // Заповни даними продукту

        when(productService.getProductById(anyLong())).thenReturn(product);

        ResponseEntity<ProductDTO> response = productController.getProductById(productId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).getProductById(productId);
    }

    @Test
    void testUpdateProduct() {
        Long productId = 1L;
        ProductDTO productDTO = new ProductDTO(); // Заповни даними продукту
        ProductDTO updatedProduct = new ProductDTO(); // Заповни даними оновленого продукту

        when(productService.updateProduct(anyLong(), any(ProductDTO.class))).thenReturn(updatedProduct);

        ResponseEntity<ProductDTO> response = productController.updateProduct(productId, productDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedProduct, response.getBody());
        verify(productService, times(1)).updateProduct(productId, productDTO);
    }

    @Test
    void testDeleteProduct() {
        Long productId = 1L;

        ResponseEntity<Void> response = productController.deleteProduct(productId);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(productService, times(1)).deleteProduct(productId);
    }
}
