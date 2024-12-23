package com.gokdemir.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoRestaurant extends DtoBase{

	private String name;
	
	private String location;
	
	private String contact;
	
	private Float rating;
	
	private Date updatedAt;
}
