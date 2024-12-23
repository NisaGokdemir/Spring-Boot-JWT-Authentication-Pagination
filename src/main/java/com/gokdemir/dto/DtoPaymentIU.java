package com.gokdemir.dto;

import java.util.Date;

import com.gokdemir.enums.PaymentStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPaymentIU {

	@NotNull
	private Float amount;
	
	@NotNull
	private Date paymentDate;
	
	@NotNull
	private PaymentStatus paymentStatus;
	
	@NotNull
	private Long paymentMethodId;
}
