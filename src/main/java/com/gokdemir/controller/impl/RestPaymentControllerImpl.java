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

import com.gokdemir.controller.IRestPaymentController;
import com.gokdemir.controller.RestBaseController;
import com.gokdemir.controller.RootEntity;
import com.gokdemir.dto.DtoPayment;
import com.gokdemir.dto.DtoPaymentIU;
import com.gokdemir.service.IPaymentService;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RequestMapping("/rest/api/payment")
@AllArgsConstructor
@RestController
public class RestPaymentControllerImpl extends RestBaseController implements IRestPaymentController{
	
	private final IPaymentService paymentService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoPayment> savePayment(@Valid @RequestBody DtoPaymentIU dtoPaymentIU) {
		return ok(paymentService.savePayment(dtoPaymentIU));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<DtoPayment> updatePayment(@PathVariable(name = "id") Long paymentId, @Valid @RequestBody DtoPaymentIU dtoPaymentIU) {
		return ok(paymentService.updatePayment(paymentId, dtoPaymentIU));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deletePayment(@PathVariable(name = "id") Long paymentId) {
		return ok(paymentService.deletePayment(paymentId));
	}

	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoPayment> findPaymentById(@PathVariable(name = "id") Long paymentId) {
		return ok(paymentService.findPaymentById(paymentId));
	}

	@GetMapping("/list")
	@Override
	public RootEntity<List<DtoPayment>> getAllPayments() {
		return ok(paymentService.getAllPayments());
	}

	@GetMapping("/list/pageable")
	@Override
	public RootEntity<RestPageableEntity<DtoPayment>> getPageableResponse(RestPageableRequest pageable) {
		return ok(paymentService.getPageableResponse(pageable));
	}

}
