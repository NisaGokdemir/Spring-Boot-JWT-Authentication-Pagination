package com.gokdemir.service;

import java.util.List;

import com.gokdemir.dto.DtoOrder;
import com.gokdemir.dto.DtoOrderIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IOrderService {

	public DtoOrder saveOrder(DtoOrderIU dtoOrderIU);
	
	public DtoOrder updateOrder(Long orderId,DtoOrderIU dtoOrderIU);
	
	public Long deleteOrder(Long orderId);
	
	public DtoOrder findOrderById(Long orderId);
	
	public List<DtoOrder> getAllOrders();
	
	public RestPageableEntity<DtoOrder> getPageableResponse(RestPageableRequest pageable);
}
