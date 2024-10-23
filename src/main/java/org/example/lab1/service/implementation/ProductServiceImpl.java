package org.example.lab1.service.implementation;

import org.example.lab1.DTO.ProductDTO;
import org.example.lab1.entity.Product;
import org.example.lab1.mappers.ProductMapper;
import org.example.lab1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;
    private final Map<Long, Product> mockProductDatabase = new HashMap<>(); // заглушка для збереження продуктів
    private Long productIdSequence = 1L; // емулюємо автоінкремент ID

    @Autowired
    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return null;
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
