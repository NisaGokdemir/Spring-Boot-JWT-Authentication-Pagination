package com.gokdemir.model;

import java.util.Date;

import com.gokdemir.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseEntity{
	
	@Column(name = "amount")
	private Float amount;
	
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@Column(name = "payment_status")
	private PaymentStatus paymentStatus;
	
	@ManyToOne
	private PaymentMethod paymentMethod;
}
