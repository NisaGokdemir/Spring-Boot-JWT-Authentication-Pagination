package com.gokdemir.service;

import java.util.List;

import com.gokdemir.dto.DtoPaymentMethod;
import com.gokdemir.dto.DtoPaymentMethodIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IPaymentMethodService {

	public DtoPaymentMethod savePaymentMethod(DtoPaymentMethodIU dtoPaymentMethodIU);
	
	public DtoPaymentMethod updatePaymentMethod(Long paymentMethodId,DtoPaymentMethodIU dtoPaymentMethodIU);
	
	public Long deletePaymentMethod(Long paymentMethodId);
	
	public DtoPaymentMethod findPaymentMethodById(Long paymentMethodId);
	
	public List<DtoPaymentMethod> getAllPaymentMethods();
	
	public RestPageableEntity<DtoPaymentMethod> getPageableResponse(RestPageableRequest pageable);
		
}
