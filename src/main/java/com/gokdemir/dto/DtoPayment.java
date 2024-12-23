package com.gokdemir.dto;

import java.util.Date;

import com.gokdemir.enums.PaymentStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPayment extends DtoBase{

	private Float amount;
	
	private Date paymentDate;
	
	private PaymentStatus paymentStatus;
	
	private DtoPaymentMethod paymentMethod;
}
