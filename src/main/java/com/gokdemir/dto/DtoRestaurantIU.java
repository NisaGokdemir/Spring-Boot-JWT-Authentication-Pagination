package com.gokdemir.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoRestaurantIU {
	
	@NotNull
	private String name;
	
	@NotNull
	private String location;
	
	@NotNull
	private String contact;
	
	@NotNull
	private Float rating;

}
