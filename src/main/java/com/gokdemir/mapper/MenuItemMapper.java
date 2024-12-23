package com.gokdemir.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gokdemir.dto.DtoMenuItem;
import com.gokdemir.dto.DtoMenuItemIU;
import com.gokdemir.model.MenuItem;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, RestaurantMapper.class})
public interface MenuItemMapper {
	
	DtoMenuItem entityToDtoMenuItem(MenuItem menuItem);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createTime", ignore = true)
	@Mapping(target = "category", ignore = true)
    @Mapping(target = "restaurants", ignore = true)
	MenuItem dtoMenuItemIUToEntity(DtoMenuItemIU dtoMenuItemIU);
	
	List<DtoMenuItem> entitiesToDtoMenuItems(List<MenuItem> menuItems);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createTime", ignore = true)
	@Mapping(target = "category", ignore = true)
    @Mapping(target = "restaurants", ignore = true)
	void updateMenuItemFromDto(DtoMenuItemIU dtoMenuItemIU, @MappingTarget MenuItem menuItem);
	

}
