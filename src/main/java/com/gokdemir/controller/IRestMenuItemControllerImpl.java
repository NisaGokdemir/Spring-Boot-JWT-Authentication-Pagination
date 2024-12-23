package com.gokdemir.controller;

import java.util.List;

import com.gokdemir.dto.DtoMenuItem;
import com.gokdemir.dto.DtoMenuItemIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IRestMenuItemControllerImpl {

	public RootEntity<DtoMenuItem> saveMenuItem(DtoMenuItemIU dtoMenuItemIU);
	
	public RootEntity<DtoMenuItem> updateMenuItem(Long menuItemId, DtoMenuItemIU dtoMenuItemIU);
	
	public RootEntity<Long> deleteMenuItem(Long menuItemId);
	
	public RootEntity<DtoMenuItem> findMenuItemById(Long menuItemId);
	
	public RootEntity<List<DtoMenuItem>> getAllMenuItems();
	
	public RootEntity<RestPageableEntity<DtoMenuItem>> getPageableResponse(RestPageableRequest pageable);
}
