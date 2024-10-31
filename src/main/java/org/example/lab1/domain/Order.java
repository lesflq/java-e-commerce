package org.example.lab1.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private long id;
    private List<Product> products;
    private LocalDateTime orderDate;
    private String customerName;

}
