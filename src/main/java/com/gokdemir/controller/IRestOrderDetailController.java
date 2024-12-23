package com.gokdemir.controller;

import java.util.List;

import com.gokdemir.dto.DtoOrderDetail;
import com.gokdemir.dto.DtoOrderDetailIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IRestOrderDetailController {

	public RootEntity<DtoOrderDetail> saveOrderDetail(DtoOrderDetailIU dtoOrderDetailIU);
	
	public RootEntity<DtoOrderDetail> updateOrderDetail(Long orderDetailId,DtoOrderDetailIU dtoOrderDetailIU);
	
	public RootEntity<Long> deleteOrderDetail(Long orderDetailId);
	
	public RootEntity<DtoOrderDetail> findOrderDetailById(Long orderDetailId);
	
	public RootEntity<List<DtoOrderDetail>> getAllOrderDetails();
	
	public RootEntity<RestPageableEntity<DtoOrderDetail>> getPageableResponse(RestPageableRequest pageable);
	
}
