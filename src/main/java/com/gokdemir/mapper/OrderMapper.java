package com.gokdemir.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gokdemir.dto.DtoOrder;
import com.gokdemir.dto.DtoOrderIU;
import com.gokdemir.model.Order;

@Mapper(componentModel = "spring", uses = {PaymentMapper.class, UserMapper.class})
public interface OrderMapper {
    
    DtoOrder entityToDtoOrder(Order order);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "payment", ignore = true)
    Order dtoOrderIUToEntity(DtoOrderIU dtoOrderIU);
    
    List<DtoOrder> entitiesToDtoOrders(List<Order> orders);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "payment", ignore = true)
    void updateOrderFromDto(DtoOrderIU dtoOrderIU, @MappingTarget Order order);

    
}

