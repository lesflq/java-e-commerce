package org.example.lab1.mappers;

import org.example.lab1.DTO.ProductDTO;
import org.example.lab1.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);


}
