package com.gokdemir.controller;

import java.util.List;

import com.gokdemir.dto.DtoPaymentMethod;
import com.gokdemir.dto.DtoPaymentMethodIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IRestPaymentMethodController {

	public RootEntity<DtoPaymentMethod> savePaymentMethod(DtoPaymentMethodIU dtoPaymentMethodIU);
	
	public RootEntity<DtoPaymentMethod> updatePaymentMethod(Long paymentMethodId,DtoPaymentMethodIU dtoPaymentMethodIU);
	
	public RootEntity<Long> deletePaymentMethod(Long paymentMethodId);
	
	public RootEntity<DtoPaymentMethod> findPaymentMethodById(Long paymentMethodId);
	
	public RootEntity<List<DtoPaymentMethod>> getAllPaymentMethods();
	
	public RootEntity<RestPageableEntity<DtoPaymentMethod>> getPageableResponse(RestPageableRequest pageable);
}
