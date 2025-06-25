package com.voidtracker.oms.order.mapper;

import com.voidtracker.oms.order.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    // Example mapping methods
    // OrderDto toDto(Order order);
    // Order toEntity(OrderDto dto);
    // Add more as needed
}
