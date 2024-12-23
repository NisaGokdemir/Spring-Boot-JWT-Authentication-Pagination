package com.gokdemir.controller.impl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gokdemir.controller.IRestAuthController;
import com.gokdemir.controller.RestBaseController;
import com.gokdemir.controller.RootEntity;
import com.gokdemir.dto.DtoUser;
import com.gokdemir.dto.DtoUserIU;
import com.gokdemir.jwt.AuthRequest;
import com.gokdemir.jwt.AuthResponse;
import com.gokdemir.jwt.RefreshTokenRequest;
import com.gokdemir.service.IAuthService;
import com.gokdemir.service.IRefreshTokenService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class RestAuthControllerImpl extends RestBaseController implements IRestAuthController{

	private final IAuthService authService;
	
	private final IRefreshTokenService refreshTokenService;

	@PostMapping("/register")
	@Override
	public RootEntity<DtoUser> register(@RequestBody DtoUserIU request) {
		return ok(authService.register(request));
	}

	@PostMapping("/authenticate")
	@Override
	public RootEntity<AuthResponse> authentication(@RequestBody AuthRequest request) {
		return ok(authService.authentication(request));
	}

	@PostMapping("/refreshToken")
	@Override
	public RootEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
		return ok(refreshTokenService.refreshToken(request));
	}


	
	
}
