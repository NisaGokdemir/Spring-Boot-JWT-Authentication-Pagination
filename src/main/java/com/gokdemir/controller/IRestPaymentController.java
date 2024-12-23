package com.gokdemir.controller;

import java.util.List;

import com.gokdemir.dto.DtoPayment;
import com.gokdemir.dto.DtoPaymentIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IRestPaymentController {

	public RootEntity<DtoPayment> savePayment(DtoPaymentIU dtoPaymentIU);
	
	public RootEntity<DtoPayment> updatePayment(Long paymentId, DtoPaymentIU dtoPaymentIU);
	
	public RootEntity<Long> deletePayment(Long paymentId);
	
	public RootEntity<DtoPayment> findPaymentById(Long paymentId);
	
	public RootEntity<List<DtoPayment>> getAllPayments();
	
	public RootEntity<RestPageableEntity<DtoPayment>> getPageableResponse(RestPageableRequest pageable);
}
