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

import com.gokdemir.controller.IRestCategoryController;
import com.gokdemir.controller.RestBaseController;
import com.gokdemir.controller.RootEntity;
import com.gokdemir.dto.DtoCategory;
import com.gokdemir.dto.DtoCategoryIU;
import com.gokdemir.service.ICategoryService;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("/rest/api/category")
@RestController
public class RestCategoryControllerImpl extends RestBaseController implements IRestCategoryController{
	
	private final ICategoryService categoryService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoCategory> saveCategory(@Valid @RequestBody DtoCategoryIU dtoCategoryIU) {
		return ok(categoryService.saveCategory(dtoCategoryIU));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<DtoCategory> updateCategory(@PathVariable(name = "id") Long categoryId, @Valid @RequestBody DtoCategoryIU dtoCategoryIU) {
		return ok(categoryService.updateCategory(categoryId, dtoCategoryIU));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deleteCategory(@PathVariable(name = "id") Long categoryId) {
		return ok(categoryService.deleteCategory(categoryId));
	}

	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoCategory> findCategoryById(@PathVariable(name = "id") Long categoryId) {
		return ok(categoryService.findCategoryById(categoryId));
	}

	@GetMapping("/list")
	@Override
	public RootEntity<List<DtoCategory>> getAllCategories() {
		return ok(categoryService.getAllCategories());
	}

	@GetMapping("/list/pageable")
	@Override
	public RootEntity<RestPageableEntity<DtoCategory>> getPageableResponse(RestPageableRequest pageable) {
		return ok(categoryService.getPageableResponse(pageable));
	}

}
