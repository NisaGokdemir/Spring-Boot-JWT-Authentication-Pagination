package com.gokdemir.dto;

import java.util.Date;

import com.gokdemir.enums.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoOrder extends DtoBase{

	private Float totalPrice;
	
	private String deliveryAddress;
	
	private OrderStatus orderStatus;
	
	private Date orderDate;
	
	private DtoUser user;
	
	private DtoPayment payment;
}
