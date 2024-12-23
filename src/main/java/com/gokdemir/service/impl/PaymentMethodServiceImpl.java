package com.gokdemir.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gokdemir.dto.DtoPaymentMethod;
import com.gokdemir.dto.DtoPaymentMethodIU;
import com.gokdemir.exception.BaseException;
import com.gokdemir.exception.ErrorMessage;
import com.gokdemir.exception.MessageType;
import com.gokdemir.mapper.PaymentMethodMapper;
import com.gokdemir.model.PaymentMethod;
import com.gokdemir.repository.PaymentMethodRepository;
import com.gokdemir.service.IPaymentMethodService;
import com.gokdemir.util.PagerUtil;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PaymentMethodServiceImpl implements IPaymentMethodService{
	
	private final PaymentMethodRepository paymentMethodRepository;
	
	private final PaymentMethodMapper paymentMethodMapper;
	
	private PaymentMethod getPaymentMethodById(Long paymentMethodId) {
		return paymentMethodRepository.findById(paymentMethodId)
			.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, paymentMethodId.toString())));
	}
	
	private PaymentMethod createPaymentMethod(DtoPaymentMethodIU dtoPaymentMethodIU) {
		return paymentMethodMapper.dtoPaymentIUToEntity(dtoPaymentMethodIU);
	}

	@Override
	public DtoPaymentMethod savePaymentMethod(DtoPaymentMethodIU dtoPaymentMethodIU) {
		PaymentMethod savedPaymentMethod = paymentMethodRepository.save(createPaymentMethod(dtoPaymentMethodIU));
		return paymentMethodMapper.entityToDtoPayment(savedPaymentMethod);
	}

	@Override
	public DtoPaymentMethod updatePaymentMethod(Long paymentMethodId, DtoPaymentMethodIU dtoPaymentMethodIU) {
		PaymentMethod paymentMethod = getPaymentMethodById(paymentMethodId);
		paymentMethodMapper.DtoPaymentMethodIUToEntity(dtoPaymentMethodIU, paymentMethod);
		PaymentMethod updatedPaymentMethod = paymentMethodRepository.save(paymentMethod);
		return paymentMethodMapper.entityToDtoPayment(updatedPaymentMethod);
	}

	@Override
	public Long deletePaymentMethod(Long paymentMethodId) {
		paymentMethodRepository.delete(getPaymentMethodById(paymentMethodId));
		return paymentMethodId;
	}

	@Override
	public DtoPaymentMethod findPaymentMethodById(Long paymentMethodId) {
		PaymentMethod paymentMethod = getPaymentMethodById(paymentMethodId);
		return paymentMethodMapper.entityToDtoPayment(paymentMethod);
	}

	@Override
	public List<DtoPaymentMethod> getAllPaymentMethods() {
		List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
		return paymentMethodMapper.entitiesToDtoPaymentMethods(paymentMethods);
	}

	@Override
	public RestPageableEntity<DtoPaymentMethod> getPageableResponse(RestPageableRequest pageable) {
		Page<PaymentMethod> page = paymentMethodRepository.findAllPageable(PagerUtil.toPageable(pageable));
		List<DtoPaymentMethod> paymentMethods = paymentMethodMapper.entitiesToDtoPaymentMethods(page.getContent());
		return PagerUtil.toPageableResponse(page, paymentMethods);
	}

}
