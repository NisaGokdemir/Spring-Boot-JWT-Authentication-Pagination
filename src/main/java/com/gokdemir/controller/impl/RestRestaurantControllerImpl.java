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

import com.gokdemir.controller.IRestRestaurantController;
import com.gokdemir.controller.RestBaseController;
import com.gokdemir.controller.RootEntity;
import com.gokdemir.dto.DtoRestaurant;
import com.gokdemir.dto.DtoRestaurantIU;
import com.gokdemir.service.IRestaurantService;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/rest/api/restaurant")
@AllArgsConstructor
@RestController
public class RestRestaurantControllerImpl extends RestBaseController implements IRestRestaurantController{
	
	private final IRestaurantService restaurantService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoRestaurant> saveRestaurant(@Valid @RequestBody DtoRestaurantIU dtoRestaurantIU) {
		return ok(restaurantService.saveRestaurant(dtoRestaurantIU));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<DtoRestaurant> updateRestaurant(@PathVariable(name = "id") Long restaurantId, @Valid @RequestBody DtoRestaurantIU dtoRestaurantIU) {
		return ok(restaurantService.updateRestaurant(restaurantId, dtoRestaurantIU));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deleteRestaurant(@PathVariable(name = "id") Long restaurantId) {
		return ok(restaurantService.deleteRestaurant(restaurantId));
	}

	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoRestaurant> findRestaurantById(@PathVariable(name = "id") Long restaurantId) {
		return ok(restaurantService.findRestaurantById(restaurantId));
	}

	@GetMapping("/list")
	@Override
	public RootEntity<List<DtoRestaurant>> getAllRestaurants() {
		return ok(restaurantService.getAllRestaurants());
	}

	@GetMapping("/list/pageable")
	@Override
	public RootEntity<RestPageableEntity<DtoRestaurant>> getPageableResponse(RestPageableRequest pageable) {
		return ok(restaurantService.getPageableResponse(pageable));
	}

}
