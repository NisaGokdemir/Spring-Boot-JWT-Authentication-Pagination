package com.gokdemir.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoOrderDetailIU {

	private Integer quantity;
	
	private Float price;
	
	private Long orderId;
	
	private Long menuItemId;
}
