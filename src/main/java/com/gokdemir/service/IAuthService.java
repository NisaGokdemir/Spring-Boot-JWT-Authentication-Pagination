package com.gokdemir.service;

import com.gokdemir.dto.DtoUser;
import com.gokdemir.dto.DtoUserIU;
import com.gokdemir.jwt.AuthRequest;
import com.gokdemir.jwt.AuthResponse;

public interface IAuthService {
	
	public DtoUser register(DtoUserIU request);
	
	public AuthResponse authentication(AuthRequest request);

}
