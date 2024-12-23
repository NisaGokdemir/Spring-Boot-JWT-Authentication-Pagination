package com.gokdemir.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gokdemir.dto.DtoUser;
import com.gokdemir.dto.DtoUserIU;
import com.gokdemir.exception.BaseException;
import com.gokdemir.exception.ErrorMessage;
import com.gokdemir.exception.MessageType;
import com.gokdemir.jwt.AuthRequest;
import com.gokdemir.jwt.AuthResponse;
import com.gokdemir.jwt.JwtService;
import com.gokdemir.mapper.UserMapper;
import com.gokdemir.model.RefreshToken;
import com.gokdemir.model.User;
import com.gokdemir.repository.RefreshTokenRepository;
import com.gokdemir.repository.UserRepository;
import com.gokdemir.service.IAuthService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements IAuthService{
	
	private final UserRepository userRepository;
	
	private final BCryptPasswordEncoder passwordEncoder;
	
	private final AuthenticationProvider authenticationProvider;
	
	private final JwtService jwtService;
	
	private final RefreshTokenRepository refreshTokenRepository;
	
	private final UserMapper userMapper;
	
	private RefreshToken createRefreshToken(User user) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
		refreshToken.setUser(user);
		return refreshToken;
	}
	
	private User createUser(DtoUserIU dtoUserIU) {
		return userMapper.dtoUserIUToEntity(dtoUserIU);
	}

	@Override
	public DtoUser register(DtoUserIU request) {
		User user = createUser(request);
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		userRepository.save(user);
		return userMapper.entityToDtoUser(user);
	}

	@Override
	public AuthResponse authentication(AuthRequest request) {
		try {
			UsernamePasswordAuthenticationToken auth =
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
			authenticationProvider.authenticate(auth);
			
			Optional<User> optUser = userRepository.findByUsername(request.getUsername());
			String accessToken = jwtService.generateToken(optUser.get());
			
			RefreshToken refreshToken = createRefreshToken(optUser.get());
			refreshTokenRepository.save(refreshToken);
			
			return new AuthResponse(accessToken,refreshToken.getRefreshToken());
			
		} catch (Exception e) {
			throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
		}
	}
	
	

}
