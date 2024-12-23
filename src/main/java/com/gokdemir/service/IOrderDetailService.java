package com.gokdemir.service;

import java.util.List;

import com.gokdemir.dto.DtoOrderDetail;
import com.gokdemir.dto.DtoOrderDetailIU;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

public interface IOrderDetailService {

	public DtoOrderDetail saveOrderDetail(DtoOrderDetailIU dtoOrderDetailIU);
	
	public DtoOrderDetail updateOrderDetail(Long orderDetailId,DtoOrderDetailIU dtoOrderDetailIU);
	
	public Long deleteOrderDetail(Long orderDetailId);
	
	public DtoOrderDetail findOrderDetailById(Long orderDetailId);
	
	public List<DtoOrderDetail> getAllOrderDetails();
	
	public RestPageableEntity<DtoOrderDetail> getPageableResponse(RestPageableRequest pageable);
	
}
