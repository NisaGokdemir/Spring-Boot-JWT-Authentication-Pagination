package com.gokdemir.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gokdemir.dto.DtoPayment;
import com.gokdemir.dto.DtoPaymentIU;
import com.gokdemir.exception.BaseException;
import com.gokdemir.exception.ErrorMessage;
import com.gokdemir.exception.MessageType;
import com.gokdemir.mapper.PaymentMapper;
import com.gokdemir.model.Payment;
import com.gokdemir.model.PaymentMethod;
import com.gokdemir.repository.PaymentMethodRepository;
import com.gokdemir.repository.PaymentRepository;
import com.gokdemir.service.IPaymentService;
import com.gokdemir.util.PagerUtil;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements IPaymentService{
	
	private final PaymentRepository paymentRepository;
	
	private final PaymentMethodRepository paymentMethodRepository;
	
	private final PaymentMapper paymentMapper;
	
	private Payment createPayment(DtoPaymentIU dtoPaymentIU) {
		return paymentMapper.dtoPaymentIUToEntity(dtoPaymentIU);
	}
	
	private PaymentMethod findPaymentMethodById(Long paymentMethodId) {
	    return paymentMethodRepository.findById(paymentMethodId)
	            .orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, paymentMethodId.toString())));
	}
	
	private Payment getPaymentById(Long paymentId) {
		return paymentRepository.findById(paymentId)
			.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, paymentId.toString())));
	}

	
	@Override
	public DtoPayment savePayment(DtoPaymentIU dtoPaymentIU) {
		Payment payment = createPayment(dtoPaymentIU);
		payment.setPaymentMethod(findPaymentMethodById(dtoPaymentIU.getPaymentMethodId()));
		paymentRepository.save(payment);
		return paymentMapper.entityToDtoPayment(payment);
	}

	@Override
	public DtoPayment updatePayment(Long paymentId, DtoPaymentIU dtoPaymentIU) {
		Payment payment = getPaymentById(paymentId);
		paymentMapper.updatePaymentFromDto(dtoPaymentIU, payment);
		payment.setPaymentMethod(findPaymentMethodById(dtoPaymentIU.getPaymentMethodId()));
		paymentRepository.save(payment);
		return paymentMapper.entityToDtoPayment(payment);
	}

	@Override
	public Long deletePayment(Long paymentId) {
		paymentRepository.delete(getPaymentById(paymentId));
		return paymentId;
	}

	@Override
	public DtoPayment findPaymentById(Long paymentId) {
		Payment payment = getPaymentById(paymentId);
		return paymentMapper.entityToDtoPayment(payment);
	}

	@Override
	public List<DtoPayment> getAllPayments() {
		List<Payment> payments = paymentRepository.findAll();
		return paymentMapper.entitiesToDtoPayments(payments);
	}

	@Override
	public RestPageableEntity<DtoPayment> getPageableResponse(RestPageableRequest pageable) {
		Page<Payment> page = paymentRepository.findAllPageable(PagerUtil.toPageable(pageable));
		List<DtoPayment> payments = paymentMapper.entitiesToDtoPayments(page.getContent());
		return PagerUtil.toPageableResponse(page, payments);
	}

	
}
