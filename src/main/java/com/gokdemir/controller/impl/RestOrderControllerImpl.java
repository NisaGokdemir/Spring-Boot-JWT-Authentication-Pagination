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

import com.gokdemir.controller.IRestOrderController;
import com.gokdemir.controller.RestBaseController;
import com.gokdemir.controller.RootEntity;
import com.gokdemir.dto.DtoOrder;
import com.gokdemir.dto.DtoOrderIU;
import com.gokdemir.service.IOrderService;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/rest/api/order")
@AllArgsConstructor
@RestController
public class RestOrderControllerImpl extends RestBaseController implements IRestOrderController{
	
	private final IOrderService orderService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoOrder> saveOrder(@Valid @RequestBody DtoOrderIU dtoOrderIU) {
		return ok(orderService.saveOrder(dtoOrderIU));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<DtoOrder> updateOrder(@PathVariable(name = "id") Long orderId,@Valid @RequestBody DtoOrderIU dtoOrderIU) {
		return ok(orderService.updateOrder(orderId, dtoOrderIU));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deleteOrder(@PathVariable(name = "id") Long orderId) {
		return ok(orderService.deleteOrder(orderId));
	}

	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoOrder> findOrderById(@PathVariable(name = "id") Long orderId) {
		return ok(orderService.findOrderById(orderId));
	}

	@GetMapping("/list")
	@Override
	public RootEntity<List<DtoOrder>> getAllOrders() {
		return ok(orderService.getAllOrders());
	}

	@GetMapping("/list/pageable")
	@Override
	public RootEntity<RestPageableEntity<DtoOrder>> getPageableResponse(RestPageableRequest pageable) {
		return ok(orderService.getPageableResponse(pageable));
	}

	
}
