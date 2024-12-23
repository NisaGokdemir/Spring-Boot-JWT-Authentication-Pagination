package com.gokdemir.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoBase {

	private Long id;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createTime;
}
