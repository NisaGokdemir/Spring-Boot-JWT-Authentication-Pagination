package com.gokdemir.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoMenuItemIU {
	
	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	@NotNull
	private Float price;
	
	@NotNull
	private boolean available;
	
	private Long categoryId;
	
	private List<Long> restaurantIds;
	
}
