package com.gokdemir.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoPaymentMethodIU {

	@NotNull
	private String name;
	
	@NotNull
	private String description;
}
