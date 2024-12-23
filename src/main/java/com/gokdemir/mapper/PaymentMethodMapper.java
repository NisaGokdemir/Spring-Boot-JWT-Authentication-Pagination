package com.gokdemir.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gokdemir.dto.DtoPaymentMethod;
import com.gokdemir.dto.DtoPaymentMethodIU;
import com.gokdemir.model.PaymentMethod;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
	
	DtoPaymentMethod entityToDtoPayment(PaymentMethod payment);
	
	@Mapping(target = "createTime", ignore = true)
	@Mapping(target = "id", ignore = true)
	PaymentMethod dtoPaymentIUToEntity(DtoPaymentMethodIU dtoPaymentMethodIU);
	
	List<DtoPaymentMethod> entitiesToDtoPaymentMethods(List<PaymentMethod> paymentMethods);
	
	@Mapping(target = "createTime", ignore = true)
	@Mapping(target = "id", ignore = true)
	void DtoPaymentMethodIUToEntity(DtoPaymentMethodIU dtoPaymentMethodIU, @MappingTarget PaymentMethod paymentMethod);
}
