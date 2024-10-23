package org.example.lab1.mappers;

import org.example.lab1.DTO.OrderDTO;
import org.example.lab1.DTO.ProductDTO;
import org.example.lab1.entity.Order;
import org.example.lab1.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")

public interface OrderMapper {
    OrderDTO toDTO(Order order);
    Order toEntity(OrderDTO orderDTO);

    List<OrderDTO> toDTOs(List<OrderDTO> ordersList);
    List<Order> toEntities(List<OrderDTO> ordersDTOList);
}
