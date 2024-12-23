package com.gokdemir.service;

import java.util.List;

import com.gokdemir.dto.DtoCategory;
import com.gokdemir.dto.DtoCategoryIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface ICategoryService {

	public DtoCategory saveCategory(DtoCategoryIU dtoCategoryIU);
	
	public DtoCategory updateCategory(Long categoryId,DtoCategoryIU dtoCategoryIU);
	
	public Long deleteCategory(Long categoryId);
	
	public DtoCategory findCategoryById(Long categoryId);
	
	public List<DtoCategory> getAllCategories();
	
	public RestPageableEntity<DtoCategory> getPageableResponse(RestPageableRequest pageable);
}
