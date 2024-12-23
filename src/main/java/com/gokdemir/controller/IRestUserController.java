package com.gokdemir.controller;

import java.util.List;

import com.gokdemir.dto.DtoUser;
import com.gokdemir.dto.DtoUserIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IRestUserController {

	public RootEntity<DtoUser> saveUser(DtoUserIU dtoUserIU);
	
	public RootEntity<DtoUser> updateUser(Long userId, DtoUserIU dtoUserIU);
	
	public RootEntity<Long> deleteUser(Long userId);
	
	public RootEntity<DtoUser> findUserById(Long userId);
	
	public RootEntity<List<DtoUser>> getAllUsers();
	
	public RootEntity<RestPageableEntity<DtoUser>>  getPageableResponse(RestPageableRequest pageable);

}
