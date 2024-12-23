package com.gokdemir.controller;

import java.util.List;

import com.gokdemir.dto.DtoCategory;
import com.gokdemir.dto.DtoCategoryIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IRestCategoryController {

	public RootEntity<DtoCategory> saveCategory(DtoCategoryIU dtoCategoryIU);
	
	public RootEntity<DtoCategory> updateCategory(Long categoryId,DtoCategoryIU dtoCategoryIU);
	
	public RootEntity<Long> deleteCategory(Long categoryId);
	
	public RootEntity<DtoCategory> findCategoryById(Long categoryId);
	
	public RootEntity<List<DtoCategory>> getAllCategories();
	
	public RootEntity<RestPageableEntity<DtoCategory>> getPageableResponse(RestPageableRequest pageable);
}
