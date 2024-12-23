package com.gokdemir.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestPageableRequest {

	private int pageNumber;
	
	private int pageSize;
	
	private String columnName;
	
	private boolean asc;
}
