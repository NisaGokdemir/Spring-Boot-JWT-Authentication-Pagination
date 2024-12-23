package com.gokdemir.dto;

import com.gokdemir.enums.Role;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUserIU {

	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private Role role;
}
