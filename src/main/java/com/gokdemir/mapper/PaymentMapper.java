package com.gokdemir.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gokdemir.dto.DtoPayment;
import com.gokdemir.dto.DtoPaymentIU;
import com.gokdemir.model.Payment;

@Mapper(componentModel = "spring", uses = PaymentMethodMapper.class)
public interface PaymentMapper {

    DtoPayment entityToDtoPayment(Payment payment);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "paymentMethod", ignore = true)
    Payment dtoPaymentIUToEntity(DtoPaymentIU dtoPaymentIU);

    List<DtoPayment> entitiesToDtoPayments(List<Payment> payments);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    @Mapping(target = "paymentMethod", ignore = true) //servis katmanında id den bulup set edeceğim
    void updatePaymentFromDto(DtoPaymentIU dtoPaymentIU, @MappingTarget Payment payment);
}
