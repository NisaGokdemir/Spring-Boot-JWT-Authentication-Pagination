package com.gokdemir.service;

import java.util.List;

import com.gokdemir.dto.DtoUser;
import com.gokdemir.dto.DtoUserIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IUserService {
	
	public DtoUser saveUser(DtoUserIU dtoUserIU);
	
	public DtoUser updateUser(Long userId, DtoUserIU dtoUserIU);
	
	public Long deleteUser(Long userId);
	
	public DtoUser findUserById(Long userId);
	
	public List<DtoUser> getAllUsers();
	
	public RestPageableEntity<DtoUser> getPageableResponse(RestPageableRequest pageable);

}
