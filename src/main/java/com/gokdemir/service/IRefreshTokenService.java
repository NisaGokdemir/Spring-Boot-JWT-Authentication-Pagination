package com.gokdemir.service;

import com.gokdemir.jwt.AuthResponse;
import com.gokdemir.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {

	public AuthResponse refreshToken(RefreshTokenRequest request);
}
