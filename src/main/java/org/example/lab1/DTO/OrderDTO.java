package org.example.lab1.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.example.lab1.domain.Product;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private long id;
    private List<Product> products;
    @NotNull
    @Past
    private LocalDateTime orderDate;
    private String customerName;
}
