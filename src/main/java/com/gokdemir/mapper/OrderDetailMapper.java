package com.gokdemir.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gokdemir.dto.DtoOrderDetail;
import com.gokdemir.dto.DtoOrderDetailIU;
import com.gokdemir.model.OrderDetail;

@Mapper(componentModel = "spring", uses = {OrderMapper.class, MenuItemMapper.class})
public interface OrderDetailMapper {

	DtoOrderDetail entityToDtoOrderDetail(OrderDetail orderDetail);
	
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "menuItem", ignore = true)
    @Mapping(target = "order", ignore = true)
	OrderDetail dtoOrderDetailIUToEntity(DtoOrderDetailIU dtoOrderDetailIU);
	
	List<DtoOrderDetail> entitiesToDtoOrderDetails(List<OrderDetail> orderDetails);
	
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "menuItem", ignore = true)
    @Mapping(target = "order", ignore = true)
	void updateOrderDetailFromDto(DtoOrderDetailIU dtoOrderDetailIU, @MappingTarget OrderDetail orderDetail);
	
}
