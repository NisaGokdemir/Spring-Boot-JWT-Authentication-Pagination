package com.gokdemir.service;

import java.util.List;

import com.gokdemir.dto.DtoMenuItem;
import com.gokdemir.dto.DtoMenuItemIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IMenuItemService {

	public DtoMenuItem saveMenuItem(DtoMenuItemIU dtoMenuItemIU);
	
	public DtoMenuItem updateMenuItem(Long menuItemId, DtoMenuItemIU dtoMenuItemIU);
	
	public Long deleteMenuItem(Long menuItemId);
	
	public DtoMenuItem findMenuItemById(Long menuItemId);
	
	public List<DtoMenuItem> getAllMenuItems();
	
	public RestPageableEntity<DtoMenuItem> getPageableResponse(RestPageableRequest pageable);
}
