package org.example.lab1.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.example.lab1.DTO.ProductDTO;
import org.example.lab1.entity.Product;
import org.example.lab1.mappers.ProductMapper;
import org.example.lab1.service.implementation.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

class ProductServiceTest  {

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product productEntity;
    private ProductDTO productDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        productEntity = new Product(1L, "Galaxy Phone", 799.99, 1);
        productDTO = new ProductDTO(1L, "Galaxy Phone", 799.99, 1);
    }

    @Test
    void testCreateProduct() {
        // Мокуємо перетворення DTO в entity
        when(productMapper.toEntity(any(ProductDTO.class))).thenReturn(productEntity);

        // Мокуємо перетворення entity в DTO після збереження
        when(productMapper.toDTO(any(Product.class))).thenReturn(productDTO);

        ProductDTO savedProduct = productService.createProduct(productDTO);

        // Перевіряємо, чи збережений продукт не є null
        assertNotNull(savedProduct);

        // Перевіряємо, що продукт збережено коректно
        assertEquals(productDTO.getName(), savedProduct.getName());
        assertEquals(1L, savedProduct.getId());
    }

    @Test
    void testGetAllProducts() {
        when(productMapper.toDTOs(anyList())).thenReturn(Arrays.asList(productDTO));

        List<ProductDTO> products = productService.getAllProducts();

        assertNotNull(products);
        assertEquals(1, products.size());
        assertEquals("Galaxy Phone", products.get(0).getName());
    }

    @Test
    void testGetProductById() {
        // Мокуємо перетворення DTO в entity
        when(productMapper.toEntity(any(ProductDTO.class))).thenReturn(productEntity);
        // Мокуємо перетворення entity в DTO
        when(productMapper.toDTO(any(Product.class))).thenReturn(productDTO);

        // Створюємо продукт і перевіряємо
        ProductDTO createdProduct = productService.createProduct(productDTO);
        assertNotNull(createdProduct);

        // Отримуємо продукт за його ID
        ProductDTO foundProduct = productService.getProductById(1L);

        assertNotNull(foundProduct);
        assertEquals("Galaxy Phone", foundProduct.getName());
    }


    @Test
    void testDeleteProduct() {
        // Мокуємо перетворення DTO в entity
        when(productMapper.toEntity(any(ProductDTO.class))).thenReturn(productEntity);
        // Мокуємо перетворення entity в DTO
        when(productMapper.toDTO(any(Product.class))).thenReturn(productDTO);

        // Створюємо продукт
        ProductDTO createdProduct = productService.createProduct(productDTO);
        assertNotNull(createdProduct);

        // Видаляємо продукт
        productService.deleteProduct(1L);

        // Перевіряємо, що при спробі отримати видалений продукт виникає RuntimeException
        assertThrows(RuntimeException.class, () -> productService.getProductById(1L), "Product not found");
    }
}
