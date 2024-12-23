package com.gokdemir.service;

import java.util.List;

import com.gokdemir.dto.DtoPayment;
import com.gokdemir.dto.DtoPaymentIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IPaymentService {

	public DtoPayment savePayment(DtoPaymentIU dtoPaymentIU);
	
	public DtoPayment updatePayment(Long paymentId, DtoPaymentIU dtoPaymentIU);
	
	public Long deletePayment(Long paymentId);
	
	public DtoPayment findPaymentById(Long paymentId);
	
	public List<DtoPayment> getAllPayments();
	
	public RestPageableEntity<DtoPayment> getPageableResponse(RestPageableRequest pageable);
}
