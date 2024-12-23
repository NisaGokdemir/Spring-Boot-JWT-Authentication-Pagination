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

import com.gokdemir.controller.IRestOrderDetailController;
import com.gokdemir.controller.RestBaseController;
import com.gokdemir.controller.RootEntity;
import com.gokdemir.dto.DtoOrderDetail;
import com.gokdemir.dto.DtoOrderDetailIU;
import com.gokdemir.service.IOrderDetailService;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("rest/api/orderDetail")
@AllArgsConstructor
@RestController
public class RestOrderDetailControllerImpl extends RestBaseController implements IRestOrderDetailController{
	
	private IOrderDetailService orderDetailService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoOrderDetail> saveOrderDetail(@Valid @RequestBody DtoOrderDetailIU dtoOrderDetailIU) {
		return ok(orderDetailService.saveOrderDetail(dtoOrderDetailIU));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<DtoOrderDetail> updateOrderDetail(@PathVariable(name = "id") Long orderDetailId, @Valid @RequestBody DtoOrderDetailIU dtoOrderDetailIU) {
		return ok(orderDetailService.updateOrderDetail(orderDetailId, dtoOrderDetailIU));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deleteOrderDetail(@PathVariable(name = "id") Long orderDetailId) {
		return ok(orderDetailService.deleteOrderDetail(orderDetailId));
	}

	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoOrderDetail> findOrderDetailById(@PathVariable(name = "id") Long orderDetailId) {
		return ok(orderDetailService.findOrderDetailById(orderDetailId));
	}

	@GetMapping("/list")
	@Override
	public RootEntity<List<DtoOrderDetail>> getAllOrderDetails() {
		return ok(orderDetailService.getAllOrderDetails());
	}

	@GetMapping("/list/pageable")
	@Override
	public RootEntity<RestPageableEntity<DtoOrderDetail>> getPageableResponse(RestPageableRequest pageable) {
		return ok(orderDetailService.getPageableResponse(pageable));
	}

	
}
