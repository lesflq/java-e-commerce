package org.example.lab1.DTO;

import jakarta.validation.constraints.NotNull;
import org.example.lab1.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private long id;
    private List<Product> products;
    @NotNull
    private LocalDateTime orderDate;
    private String customerName;
}
