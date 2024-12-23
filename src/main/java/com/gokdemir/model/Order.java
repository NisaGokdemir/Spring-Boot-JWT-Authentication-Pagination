package com.gokdemir.model;

import java.util.Date;

import com.gokdemir.enums.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity{
	
	@Column(name = "total_price")
	private Float totalPrice;
	
	@Column(name = "delivery_address")
	private String deliveryAddress;
	
	@Column(name = "order_status")
	private OrderStatus orderStatus;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@OneToOne
	private Payment payment;
}
