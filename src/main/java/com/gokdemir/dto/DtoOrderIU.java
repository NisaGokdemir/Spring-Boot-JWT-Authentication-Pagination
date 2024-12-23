package com.gokdemir.dto;

import java.util.Date;

import com.gokdemir.enums.OrderStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoOrderIU {

	@NotNull
	private Float totalPrice;

	@NotNull
	private String deliveryAddress;
	
	@NotNull
	private OrderStatus orderStatus;
	
	@NotNull
	private Date orderDate;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private Long paymentId;
	
}
