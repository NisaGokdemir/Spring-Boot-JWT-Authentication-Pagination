package com.gokdemir.util;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PagerUtil {

	public boolean isNullOrEmpty(String value) {
		return value == null || value.trim().length() == 0;
	}
	
	public Pageable toPageable(RestPageableRequest request) {
		if (!isNullOrEmpty(request.getColumnName())) {
			Sort sortBy = request.isAsc() ? Sort.by(Direction.ASC, request.getColumnName())
					: Sort.by(Direction.DESC, request.getColumnName());
			
			return PageRequest.of(request.getPageNumber(), request.getPageSize(), sortBy);
		}
		
		return PageRequest.of(request.getPageNumber(), request.getPageSize());
	}
	
	public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content){
		RestPageableEntity<T> pageableEntity = new RestPageableEntity<T>();
		pageableEntity.setContent(content);
		pageableEntity.setPageNumber(page.getPageable().getPageNumber());
		pageableEntity.setPageSize(page.getPageable().getPageSize());
		pageableEntity.setTotalElements(page.getTotalElements());
		return pageableEntity;
	}
}
