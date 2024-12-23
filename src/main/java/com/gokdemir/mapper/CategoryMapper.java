package com.gokdemir.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gokdemir.dto.DtoCategory;
import com.gokdemir.dto.DtoCategoryIU;
import com.gokdemir.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

//	CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
	
	DtoCategory entityToDtoCategory(Category category);
	
	@Mapping(target = "createTime", ignore = true)
    @Mapping(target = "id", ignore = true) 
	Category dtoCategoryIUToEntity(DtoCategoryIU dtoCategoryIU);
	
	List<DtoCategory> entitiesToDtoCategories(List<Category> categories);
	
	@Mapping(target = "createTime", ignore = true)
	@Mapping(target = "id", ignore = true) 
    void dtoCategoryIUToEntity(DtoCategoryIU dtoCategoryIU, @MappingTarget Category category);
}
