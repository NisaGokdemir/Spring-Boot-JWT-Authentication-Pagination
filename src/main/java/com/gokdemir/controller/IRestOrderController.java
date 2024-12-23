package com.gokdemir.controller;

import java.util.List;

import com.gokdemir.dto.DtoOrder;
import com.gokdemir.dto.DtoOrderIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IRestOrderController {

	public RootEntity<DtoOrder> saveOrder(DtoOrderIU dtoOrderIU);
	
	public RootEntity<DtoOrder> updateOrder(Long orderId,DtoOrderIU dtoOrderIU);
	
	public RootEntity<Long> deleteOrder(Long orderId);
	
	public RootEntity<DtoOrder> findOrderById(Long orderId);
	
	public RootEntity<List<DtoOrder>> getAllOrders();
	
	public RootEntity<RestPageableEntity<DtoOrder>> getPageableResponse(RestPageableRequest pageable);
}
