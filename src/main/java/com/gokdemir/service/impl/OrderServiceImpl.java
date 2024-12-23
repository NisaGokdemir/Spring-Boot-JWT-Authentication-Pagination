package com.gokdemir.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.gokdemir.dto.DtoOrder;
import com.gokdemir.dto.DtoOrderIU;
import com.gokdemir.exception.BaseException;
import com.gokdemir.exception.ErrorMessage;
import com.gokdemir.exception.MessageType;
import com.gokdemir.mapper.OrderMapper;
import com.gokdemir.model.Order;
import com.gokdemir.model.Payment;
import com.gokdemir.model.User;
import com.gokdemir.repository.OrderRepository;
import com.gokdemir.repository.PaymentRepository;
import com.gokdemir.repository.UserRepository;
import com.gokdemir.service.IOrderService;
import com.gokdemir.util.PagerUtil;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService{
	
	private final OrderRepository orderRepository;
	
	private UserRepository userRepository;
	
	private PaymentRepository paymentRepository;
	
	private final OrderMapper orderMapper;
	
	private Order createOrder(DtoOrderIU dtoOrderIU) {
		return orderMapper.dtoOrderIUToEntity(dtoOrderIU);
	}
	
	private Order getOrderById(Long orderId) {
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, orderId.toString())));
	}
	
	private User getUserById(Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, userId.toString())));
	}
	
	private Payment getPaymentById(Long paymentId) {
		return paymentRepository.findById(paymentId)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, paymentId.toString())));
	}
	
	
	@Override
	public DtoOrder saveOrder(DtoOrderIU dtoOrderIU) {
	    Order order = createOrder(dtoOrderIU);
	    order.setUser(getUserById(dtoOrderIU.getUserId())); 
	    order.setPayment(getPaymentById(dtoOrderIU.getPaymentId())); 
	    orderRepository.save(order);
	    return orderMapper.entityToDtoOrder(order);
	}


	@Override
	public DtoOrder updateOrder(Long orderId, DtoOrderIU dtoOrderIU) {
		Order order = getOrderById(orderId);
		orderMapper.updateOrderFromDto(dtoOrderIU, order);
		order.setPayment(getPaymentById(dtoOrderIU.getPaymentId()));
		order.setUser(getUserById(dtoOrderIU.getUserId()));
		orderRepository.save(order);
		return orderMapper.entityToDtoOrder(order);
	}

	@Override
	public Long deleteOrder(Long orderId) {
		orderRepository.delete(getOrderById(orderId));
		return orderId;
	}

	@Override
	public DtoOrder findOrderById(Long orderId) {
		Order order = getOrderById(orderId);
		return orderMapper.entityToDtoOrder(order);
	}

	@Override
	public List<DtoOrder> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		return orderMapper.entitiesToDtoOrders(orders);
	}

	@Override
	public RestPageableEntity<DtoOrder> getPageableResponse(RestPageableRequest pageable) {
		Page<Order> page = orderRepository.findAllPageable(PagerUtil.toPageable(pageable));
		List<DtoOrder> orders = orderMapper.entitiesToDtoOrders(page.getContent());
		return PagerUtil.toPageableResponse(page, orders);
	}

}
