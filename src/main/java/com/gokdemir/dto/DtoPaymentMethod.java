package com.gokdemir.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPaymentMethod extends DtoBase{

	private String name;
	
	private String description;
}
