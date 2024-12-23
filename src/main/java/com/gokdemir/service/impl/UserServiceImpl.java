package com.gokdemir.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gokdemir.dto.DtoUser;
import com.gokdemir.dto.DtoUserIU;
import com.gokdemir.exception.BaseException;
import com.gokdemir.exception.ErrorMessage;
import com.gokdemir.exception.MessageType;
import com.gokdemir.mapper.UserMapper;
import com.gokdemir.model.User;
import com.gokdemir.repository.UserRepository;
import com.gokdemir.service.IUserService;
import com.gokdemir.util.PagerUtil;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserServiceImpl implements IUserService{
	
	private final UserMapper userMapper;

	private final UserRepository userRepository;
	
	
	private User createUser(DtoUserIU dtoUserIU) {
	    return userMapper.dtoUserIUToEntity(dtoUserIU);
	}
	
	private User getUserById(Long userId) {
	    return userRepository.findById(userId)
	    		.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, userId.toString())));
	}

	
	@Override
	public DtoUser saveUser(DtoUserIU dtoUserIU) {
		User savedUser = userRepository.save(createUser(dtoUserIU));
		return userMapper.entityToDtoUser(savedUser);
	}


	@Override
	public DtoUser updateUser(Long userId, DtoUserIU dtoUserIU) {
		User userToUpdate = getUserById(userId);
		userMapper.dtoUserIUToEntity(dtoUserIU, userToUpdate);
		User updatedUser = userRepository.save(userToUpdate);
		return userMapper.entityToDtoUser(updatedUser);
	}


	@Override
	public Long deleteUser(Long userId) {
		userRepository.delete(getUserById(userId));
		return userId;
	}

	@Override
	public DtoUser findUserById(Long userId) {
		User user = getUserById(userId);
		return userMapper.entityToDtoUser(user);
	}

	@Override
	public List<DtoUser> getAllUsers() {
		List<User> users = userRepository.findAll();
		return userMapper.entitiesToDtoUsers(users);
	}

	@Override
	public RestPageableEntity<DtoUser> getPageableResponse(RestPageableRequest pageable) {
		Page<User> page = userRepository.findAllPageable(PagerUtil.toPageable(pageable));
		List<DtoUser> dtoUsers= userMapper.entitiesToDtoUsers(page.getContent());
		return PagerUtil.toPageableResponse(page, dtoUsers);
	}


	
	

}
