package com.gokdemir.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gokdemir.dto.DtoOrderDetail;
import com.gokdemir.dto.DtoOrderDetailIU;
import com.gokdemir.exception.BaseException;
import com.gokdemir.exception.ErrorMessage;
import com.gokdemir.exception.MessageType;
import com.gokdemir.mapper.OrderDetailMapper;
import com.gokdemir.model.MenuItem;
import com.gokdemir.model.Order;
import com.gokdemir.model.OrderDetail;
import com.gokdemir.repository.MenuItemRepository;
import com.gokdemir.repository.OrderDetailRepository;
import com.gokdemir.repository.OrderRepository;
import com.gokdemir.service.IOrderDetailService;
import com.gokdemir.util.PagerUtil;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class OrderDetailServiceImpl implements IOrderDetailService{
	
	private OrderDetailMapper orderDetailMapper;
	
	private OrderDetailRepository orderDetailRepository;
	
	private MenuItemRepository menuItemRepository;
	
	private OrderRepository orderRepository;
	
	
	private OrderDetail createOrderDetail(DtoOrderDetailIU dtoOrderDetailIU) {
		return orderDetailMapper.dtoOrderDetailIUToEntity(dtoOrderDetailIU);
	}
	
	private MenuItem getMenuItemById(Long menuItemId) {
		return menuItemRepository.findById(menuItemId)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, menuItemId.toString())));
	}
	
	private Order getOrderById(Long orderId) {
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, orderId.toString())));
	}
	
	private OrderDetail getOrderDetailById(Long orderDetailId) {
		return orderDetailRepository.findById(orderDetailId)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, orderDetailId.toString())));
	}
	
	@Override
	public DtoOrderDetail saveOrderDetail(DtoOrderDetailIU dtoOrderDetailIU) {
		OrderDetail orderDetail = createOrderDetail(dtoOrderDetailIU);
		orderDetail.setMenuItem(getMenuItemById(dtoOrderDetailIU.getMenuItemId()));
		orderDetail.setOrder(getOrderById(dtoOrderDetailIU.getOrderId()));
		orderDetailRepository.save(orderDetail);
		return orderDetailMapper.entityToDtoOrderDetail(orderDetail);
	}

	@Override
	public DtoOrderDetail updateOrderDetail(Long orderDetailId,DtoOrderDetailIU dtoOrderDetailIU) {
		OrderDetail orderDetail = getOrderDetailById(orderDetailId);
		orderDetailMapper.updateOrderDetailFromDto(dtoOrderDetailIU, orderDetail);
		orderDetail.setMenuItem(getMenuItemById(dtoOrderDetailIU.getMenuItemId()));
		orderDetail.setOrder(getOrderById(dtoOrderDetailIU.getOrderId()));
		orderDetailRepository.save(orderDetail);
		return orderDetailMapper.entityToDtoOrderDetail(orderDetail);
	}

	@Override
	public Long deleteOrderDetail(Long orderDetailId) {
		orderDetailRepository.delete(getOrderDetailById(orderDetailId));
		return orderDetailId;
	}

	@Override
	public DtoOrderDetail findOrderDetailById(Long orderDetailId) {
		OrderDetail orderDetail = getOrderDetailById(orderDetailId);
		return orderDetailMapper.entityToDtoOrderDetail(orderDetail);
	}

	@Override
	public List<DtoOrderDetail> getAllOrderDetails() {
		List<OrderDetail> orderDetails = orderDetailRepository.findAll();
		return orderDetailMapper.entitiesToDtoOrderDetails(orderDetails);
	}

	@Override
	public RestPageableEntity<DtoOrderDetail> getPageableResponse(RestPageableRequest pageable) {
		Page<OrderDetail> page = orderDetailRepository.findAllPageable(PagerUtil.toPageable(pageable));
		List<DtoOrderDetail> orderDetails = orderDetailMapper.entitiesToDtoOrderDetails(page.getContent());
		return PagerUtil.toPageableResponse(page, orderDetails);
	}

}
