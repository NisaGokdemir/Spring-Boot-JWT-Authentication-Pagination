package com.gokdemir.dto;

import com.gokdemir.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUser extends DtoBase{

	private String username;
	
	private String password;
	
	private Role role;
}
