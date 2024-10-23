package org.example.lab1.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CategoryDTO {
    private long id;
    @NotNull
    @Size(min = 2, max = 50, message = "Category name must be between 3 and 50 characters")
    private String name;
}
