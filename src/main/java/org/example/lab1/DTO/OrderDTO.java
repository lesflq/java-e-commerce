package org.example.lab1.DTO;

import org.example.lab1.entity.Product;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private long id;
    private List<Product> products;
    private LocalDateTime orderDate;
    private String customerName;
}
