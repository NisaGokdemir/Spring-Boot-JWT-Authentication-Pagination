package com.gokdemir.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.gokdemir.dto.DtoRestaurant;
import com.gokdemir.dto.DtoRestaurantIU;
import com.gokdemir.model.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
	
	DtoRestaurant entityToDtoRestaurant(Restaurant restaurant);
	
	@Mapping(target = "createTime", ignore = true)
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	Restaurant dtoRestaurantIUToEntity(DtoRestaurantIU dtoRestaurantIU);
	
	List<DtoRestaurant> entitiesToDtoRestaurants(List<Restaurant> restaurants);
	
	@Mapping(target = "createTime", ignore = true)
	@Mapping(target = "id", ignore = true) 
	@Mapping(target = "updatedAt", ignore = true)
	void dtoRestaurantIUToEntity(DtoRestaurantIU dtoRestaurantIU, @MappingTarget Restaurant restaurant);
}
