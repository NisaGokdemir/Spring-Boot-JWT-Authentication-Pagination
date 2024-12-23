package com.gokdemir.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gokdemir.controller.IRestUserController;
import com.gokdemir.controller.RestBaseController;
import com.gokdemir.controller.RootEntity;
import com.gokdemir.dto.DtoUser;
import com.gokdemir.dto.DtoUserIU;
import com.gokdemir.service.IUserService;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/rest/api/user")
@RestController
public class RestUserControllerImpl extends RestBaseController implements IRestUserController{
	
	private final IUserService userService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoUser> saveUser(@Valid @RequestBody DtoUserIU dtoUserIU) {
		return ok(userService.saveUser(dtoUserIU));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<DtoUser> updateUser(@PathVariable(name = "id") Long userId, @Valid @RequestBody DtoUserIU dtoUserIU) {
		return ok(userService.updateUser(userId, dtoUserIU));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deleteUser(@PathVariable(name = "id") Long userId) {
		return ok(userService.deleteUser(userId));
	}

	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoUser> findUserById(@PathVariable(name = "id") Long userId) {
		return ok(userService.findUserById(userId));
	}

	@GetMapping("/list")
	@Override
	public RootEntity<List<DtoUser>> getAllUsers() {
		return ok(userService.getAllUsers());
	}

	@GetMapping("/list/pageable")
	@Override
	public RootEntity<RestPageableEntity<DtoUser>> getPageableResponse(RestPageableRequest pageable) {
		return ok(userService.getPageableResponse(pageable));
	}

}
