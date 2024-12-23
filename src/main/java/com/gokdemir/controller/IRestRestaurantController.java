package com.gokdemir.controller;

import java.util.List;

import com.gokdemir.dto.DtoRestaurant;
import com.gokdemir.dto.DtoRestaurantIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IRestRestaurantController {

	public RootEntity<DtoRestaurant> saveRestaurant(DtoRestaurantIU dtoRestaurantIU);
	
	public RootEntity<DtoRestaurant> updateRestaurant(Long restaurantId,DtoRestaurantIU dtoRestaurantIU);
	
	public RootEntity<Long> deleteRestaurant(Long restaurantId);
	
	public RootEntity<DtoRestaurant> findRestaurantById(Long restaurantId);
	
	public RootEntity<List<DtoRestaurant>> getAllRestaurants();
	
	public RootEntity<RestPageableEntity<DtoRestaurant>> getPageableResponse(RestPageableRequest pageable);
}
