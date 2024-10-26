package org.example.lab1.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.lab1.DTO.OrderDTO;
import org.example.lab1.entity.Order;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-24T23:05:56+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDTO toDTO(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDTO orderDTO = new OrderDTO();

        return orderDTO;
    }

    @Override
    public Order toEntity(OrderDTO orderDTO) {
        if ( orderDTO == null ) {
            return null;
        }

        Order order = new Order();

        return order;
    }

    @Override
    public List<OrderDTO> toDTOs(List<OrderDTO> ordersList) {
        if ( ordersList == null ) {
            return null;
        }

        List<OrderDTO> list = new ArrayList<OrderDTO>( ordersList.size() );
        for ( OrderDTO orderDTO : ordersList ) {
            list.add( orderDTO );
        }

        return list;
    }

    @Override
    public List<Order> toEntities(List<OrderDTO> ordersDTOList) {
        if ( ordersDTOList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( ordersDTOList.size() );
        for ( OrderDTO orderDTO : ordersDTOList ) {
            list.add( toEntity( orderDTO ) );
        }

        return list;
    }
}
