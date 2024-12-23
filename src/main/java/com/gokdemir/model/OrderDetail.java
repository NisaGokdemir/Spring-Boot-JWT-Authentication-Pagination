package com.gokdemir.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail extends BaseEntity{

	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "price")
	private Float price;
	
	@ManyToOne
	private Order order;
	
	@ManyToOne
	private MenuItem menuItem;
}
