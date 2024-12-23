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

import com.gokdemir.controller.IRestMenuItemControllerImpl;
import com.gokdemir.controller.RestBaseController;
import com.gokdemir.controller.RootEntity;
import com.gokdemir.dto.DtoMenuItem;
import com.gokdemir.dto.DtoMenuItemIU;
import com.gokdemir.service.IMenuItemService;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/rest/api/menuItem")
@RestController
public class RestMenuItemControllerImpl extends RestBaseController implements IRestMenuItemControllerImpl{
	
	private final IMenuItemService menuItemService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoMenuItem> saveMenuItem(@Valid @RequestBody DtoMenuItemIU dtoMenuItemIU) {
		return ok(menuItemService.saveMenuItem(dtoMenuItemIU));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<DtoMenuItem> updateMenuItem(@PathVariable(name = "id") Long menuItemId,@Valid @RequestBody DtoMenuItemIU dtoMenuItemIU) {
		return ok(menuItemService.updateMenuItem(menuItemId, dtoMenuItemIU));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deleteMenuItem(@PathVariable(name = "id") Long menuItemId) {
		return ok(menuItemService.deleteMenuItem(menuItemId));
	}

	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoMenuItem> findMenuItemById(@PathVariable(name = "id") Long menuItemId) {
		return ok(menuItemService.findMenuItemById(menuItemId));
	}

	@GetMapping("/list")
	@Override
	public RootEntity<List<DtoMenuItem>> getAllMenuItems() {
		return ok(menuItemService.getAllMenuItems());
	}

	@GetMapping("/list/pageable")
	@Override
	public RootEntity<RestPageableEntity<DtoMenuItem>> getPageableResponse(RestPageableRequest pageable) {
		return ok(menuItemService.getPageableResponse(pageable));
	}

}
