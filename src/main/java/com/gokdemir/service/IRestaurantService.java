package com.gokdemir.service;

import java.util.List;

import com.gokdemir.dto.DtoRestaurant;
import com.gokdemir.dto.DtoRestaurantIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IRestaurantService {

	public DtoRestaurant saveRestaurant(DtoRestaurantIU dtoRestaurantIU);
	
	public DtoRestaurant updateRestaurant(Long restaurantId,DtoRestaurantIU dtoRestaurantIU);
	
	public Long deleteRestaurant(Long restaurantId);
	
	public DtoRestaurant findRestaurantById(Long restaurantId);
	
	public List<DtoRestaurant> getAllRestaurants();
	
	public RestPageableEntity<DtoRestaurant> getPageableResponse(RestPageableRequest pageable);
}
