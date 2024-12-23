package com.gokdemir.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gokdemir.dto.DtoCategory;
import com.gokdemir.dto.DtoCategoryIU;
import com.gokdemir.exception.BaseException;
import com.gokdemir.exception.ErrorMessage;
import com.gokdemir.exception.MessageType;
import com.gokdemir.mapper.CategoryMapper;
import com.gokdemir.model.Category;
import com.gokdemir.repository.CategoryRepository;
import com.gokdemir.service.ICategoryService;
import com.gokdemir.util.PagerUtil;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService{
	
	private final CategoryRepository categoryRepository;
	
	private final CategoryMapper categoryMapper;
	
	private Category createCategory(DtoCategoryIU dtoCategoryIU) {
		return categoryMapper.dtoCategoryIUToEntity(dtoCategoryIU);
	}
	
	private Category getCategoryById(Long categoryId) {
		 return categoryRepository.findById(categoryId)
			.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, categoryId.toString())));	
	}
	
	@Override
	public DtoCategory saveCategory(DtoCategoryIU dtoCategoryIU) {
		Category savedCategory = categoryRepository.save(createCategory(dtoCategoryIU));
		return categoryMapper.entityToDtoCategory(savedCategory);
	}

	@Override
	public DtoCategory updateCategory(Long categoryId,DtoCategoryIU dtoCategoryIU) {
	    Category categoryToUpdate = getCategoryById(categoryId);
	    categoryMapper.dtoCategoryIUToEntity(dtoCategoryIU, categoryToUpdate); 
	    Category updatedCategory = categoryRepository.save(categoryToUpdate);
	    return categoryMapper.entityToDtoCategory(updatedCategory);
	}

	@Override
	public Long deleteCategory(Long categoryId) {
		categoryRepository.delete(getCategoryById(categoryId));
		return categoryId;
	}

	@Override
	public DtoCategory findCategoryById(Long categoryId) {
		Category category = getCategoryById(categoryId);
		return categoryMapper.entityToDtoCategory(category);
	}

	@Override
	public List<DtoCategory> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categoryMapper.entitiesToDtoCategories(categories);
	}

	@Override
	public RestPageableEntity<DtoCategory> getPageableResponse(RestPageableRequest pageable) {
		Page<Category> page = categoryRepository.findAllPageable(PagerUtil.toPageable(pageable));
		List<DtoCategory> dtoCategories =categoryMapper.entitiesToDtoCategories(page.getContent());
		return PagerUtil.toPageableResponse(page, dtoCategories);
	}

}
