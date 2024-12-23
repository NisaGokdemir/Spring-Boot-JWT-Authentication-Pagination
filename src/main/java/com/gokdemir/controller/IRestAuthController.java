package com.gokdemir.controller;

import com.gokdemir.dto.DtoUser;
import com.gokdemir.dto.DtoUserIU;
import com.gokdemir.jwt.AuthRequest;
import com.gokdemir.jwt.AuthResponse;
import com.gokdemir.jwt.RefreshTokenRequest;

public interface IRestAuthController {
	
	public RootEntity<DtoUser> register(DtoUserIU request);
	
	public RootEntity<AuthResponse> authentication(AuthRequest request);
	
	public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest request);

}
