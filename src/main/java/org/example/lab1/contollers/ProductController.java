package org.example.lab1.contollers;

import org.example.lab1.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        // Realization
        return null;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts() {
        // Realization
        return null;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // Realization
        return null;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product) {
        // Realization
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable long id) {
        // Realization
        return null;
    }
}
