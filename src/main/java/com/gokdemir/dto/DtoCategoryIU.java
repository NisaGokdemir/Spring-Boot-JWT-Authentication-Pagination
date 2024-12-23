package com.gokdemir.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCategoryIU {

	@NotNull
	private String name;
	
	@NotNull
	private String description;
}
