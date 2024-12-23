package com.gokdemir.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoOrderDetail extends DtoBase{

	private Integer quantity;
	
	private Float price;
	
	private DtoOrder order;
	
	private DtoMenuItem menuItem;
}
