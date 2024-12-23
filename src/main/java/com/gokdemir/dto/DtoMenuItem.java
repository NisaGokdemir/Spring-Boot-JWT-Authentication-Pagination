package com.gokdemir.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoMenuItem extends DtoBase{

	private String name;
	
	private String description;
	
	private Float price;
	
	private boolean available;
	
	private DtoCategory category;
	
	private List<DtoRestaurant> restaurants;
}
