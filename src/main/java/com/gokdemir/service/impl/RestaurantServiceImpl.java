package com.gokdemir.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gokdemir.dto.DtoRestaurant;
import com.gokdemir.dto.DtoRestaurantIU;
import com.gokdemir.exception.BaseException;
import com.gokdemir.exception.ErrorMessage;
import com.gokdemir.exception.MessageType;
import com.gokdemir.mapper.RestaurantMapper;
import com.gokdemir.model.Restaurant;
import com.gokdemir.repository.RestaurantRepository;
import com.gokdemir.service.IRestaurantService;
import com.gokdemir.util.PagerUtil;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RestaurantServiceImpl implements IRestaurantService{
	
	private final RestaurantRepository restaurantRepository;
	
	private final RestaurantMapper restaurantMapper;
	
	
	private Restaurant createRestaurant(DtoRestaurantIU dtoRestaurantIU) {
		return restaurantMapper.dtoRestaurantIUToEntity(dtoRestaurantIU);
	}
	
	private Restaurant getRestaurantById(Long restaurantId) {
		return restaurantRepository.findById(restaurantId)
			.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, restaurantId.toString())));
	}

	@Override
	public DtoRestaurant saveRestaurant(DtoRestaurantIU dtoRestaurantIU) {
		Restaurant restaurant = restaurantRepository.save(createRestaurant(dtoRestaurantIU));
		return restaurantMapper.entityToDtoRestaurant(restaurant);
	}

	@Override
	public DtoRestaurant updateRestaurant(Long restaurantId,DtoRestaurantIU dtoRestaurantIU) {
		Restaurant restaurant = getRestaurantById(restaurantId);
		restaurantMapper.dtoRestaurantIUToEntity(dtoRestaurantIU, restaurant);
		restaurantRepository.save(restaurant);
		return restaurantMapper.entityToDtoRestaurant(restaurant);
	}

	@Override
	public Long deleteRestaurant(Long restaurantId) {
		restaurantRepository.delete(getRestaurantById(restaurantId));
		return restaurantId;
	}

	@Override
	public DtoRestaurant findRestaurantById(Long restaurantId) {
		Restaurant restaurant = getRestaurantById(restaurantId);
		return restaurantMapper.entityToDtoRestaurant(restaurant);
	}

	@Override
	public List<DtoRestaurant> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurantMapper.entitiesToDtoRestaurants(restaurants);
	}

	@Override
	public RestPageableEntity<DtoRestaurant> getPageableResponse(RestPageableRequest pageable) {
		Page<Restaurant> page = restaurantRepository.findAllPageable(PagerUtil.toPageable(pageable));
		List<DtoRestaurant> restaurants = restaurantMapper.entitiesToDtoRestaurants(page.getContent());
		return PagerUtil.toPageableResponse(page, restaurants);
	}

}
