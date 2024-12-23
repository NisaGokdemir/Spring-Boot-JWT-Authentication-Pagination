package com.gokdemir.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gokdemir.dto.DtoMenuItem;
import com.gokdemir.dto.DtoMenuItemIU;
import com.gokdemir.exception.BaseException;
import com.gokdemir.exception.ErrorMessage;
import com.gokdemir.exception.MessageType;
import com.gokdemir.mapper.MenuItemMapper;
import com.gokdemir.model.Category;
import com.gokdemir.model.MenuItem;
import com.gokdemir.model.Restaurant;
import com.gokdemir.repository.CategoryRepository;
import com.gokdemir.repository.MenuItemRepository;
import com.gokdemir.repository.RestaurantRepository;
import com.gokdemir.service.IMenuItemService;
import com.gokdemir.util.PagerUtil;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuItemServiceImpl implements IMenuItemService{
	
	private final MenuItemMapper menuItemMapper;
	
	private final MenuItemRepository menuItemRepository;
	
	private final CategoryRepository categoryRepository;
	
	private final RestaurantRepository restaurantRepository;
	
	private MenuItem createMenuItem(DtoMenuItemIU dtoMenuItemIU) {
		return menuItemMapper.dtoMenuItemIUToEntity(dtoMenuItemIU);
	}
	
	private Category getCategoryById(Long categoryId) {
		return categoryRepository.findById(categoryId)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, categoryId.toString())));
	}
	
	private List<Restaurant> getRestaurantsByIds(List<Long> restaurantIds) {
	    List<Restaurant> restaurants = restaurantRepository.findAllById(restaurantIds);

	    List<Long> foundIds = new ArrayList<>();
	    for (Restaurant restaurant : restaurants) {
	        foundIds.add(restaurant.getId());
	    }

	    List<Long> missingIds = new ArrayList<>();
	    for (Long id : restaurantIds) {
	        if (!foundIds.contains(id)) {
	            missingIds.add(id);
	        }
	    }

	    if (!missingIds.isEmpty()) {
	        throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, missingIds.toString()));
	    }

	    return restaurants;
	}

	
	private MenuItem getMenuItemById(Long menuItemId) {
		return menuItemRepository.findById(menuItemId)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, menuItemId.toString())));
	}
	
	@Override
	public DtoMenuItem saveMenuItem(DtoMenuItemIU dtoMenuItemIU) {
		MenuItem menuItem = createMenuItem(dtoMenuItemIU);
		menuItem.setCategory(getCategoryById(dtoMenuItemIU.getCategoryId()));
		menuItem.setRestaurants(getRestaurantsByIds(dtoMenuItemIU.getRestaurantIds()));
		menuItemRepository.save(menuItem);
		return menuItemMapper.entityToDtoMenuItem(menuItem);
	}

	@Override
	public DtoMenuItem updateMenuItem(Long menuItemId, DtoMenuItemIU dtoMenuItemIU) {
		MenuItem menuItem = getMenuItemById(menuItemId);
		menuItemMapper.updateMenuItemFromDto(dtoMenuItemIU, menuItem);
		menuItem.setRestaurants(getRestaurantsByIds(dtoMenuItemIU.getRestaurantIds()));
		menuItem.setCategory(getCategoryById(dtoMenuItemIU.getCategoryId()));
		menuItemRepository.save(menuItem);
		return menuItemMapper.entityToDtoMenuItem(menuItem);
	}

	@Override
	public Long deleteMenuItem(Long menuItemId) {
		menuItemRepository.delete(getMenuItemById(menuItemId));
		return menuItemId;
	}

	@Override
	public DtoMenuItem findMenuItemById(Long menuItemId) {
		MenuItem menuItem = getMenuItemById(menuItemId);
		return menuItemMapper.entityToDtoMenuItem(menuItem);
	}

	@Override
	public List<DtoMenuItem> getAllMenuItems() {
		List<MenuItem> menuItems = menuItemRepository.findAll();
		return menuItemMapper.entitiesToDtoMenuItems(menuItems);
	}

	@Override
	public RestPageableEntity<DtoMenuItem> getPageableResponse(RestPageableRequest pageable) {
		Page<MenuItem> page = menuItemRepository.findAllPageable(PagerUtil.toPageable(pageable));
		List<DtoMenuItem> menuItems = menuItemMapper.entitiesToDtoMenuItems(page.getContent());
		return PagerUtil.toPageableResponse(page, menuItems);
	}

}
