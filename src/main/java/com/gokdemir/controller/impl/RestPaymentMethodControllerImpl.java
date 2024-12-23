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

import com.gokdemir.controller.IRestPaymentMethodController;
import com.gokdemir.controller.RestBaseController;
import com.gokdemir.controller.RootEntity;
import com.gokdemir.dto.DtoPaymentMethod;
import com.gokdemir.dto.DtoPaymentMethodIU;
import com.gokdemir.service.IPaymentMethodService;
import com.gokdemir.util.RestPageableEntity;
import com.gokdemir.util.RestPageableRequest;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestMapping("rest/api/paymentMethod")
@RestController
public class RestPaymentMethodControllerImpl extends RestBaseController implements IRestPaymentMethodController {
	
	private final IPaymentMethodService paymentMethodService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoPaymentMethod> savePaymentMethod(@Valid @RequestBody DtoPaymentMethodIU dtoPaymentMethodIU) {
		return ok(paymentMethodService.savePaymentMethod(dtoPaymentMethodIU));
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<DtoPaymentMethod> updatePaymentMethod(@PathVariable(name = "id") Long paymentMethodId,@Valid @RequestBody DtoPaymentMethodIU dtoPaymentMethodIU) {
		return ok(paymentMethodService.updatePaymentMethod(paymentMethodId, dtoPaymentMethodIU));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Long> deletePaymentMethod(@PathVariable(name = "id") Long paymentMethodId) {
		return ok(paymentMethodService.deletePaymentMethod(paymentMethodId));
	}

	@GetMapping("/list/{id}")
	@Override
	public RootEntity<DtoPaymentMethod> findPaymentMethodById(@PathVariable(name = "id") Long paymentMethodId) {
		return ok(paymentMethodService.findPaymentMethodById(paymentMethodId));
	}

	@GetMapping("/list")
	@Override
	public RootEntity<List<DtoPaymentMethod>> getAllPaymentMethods() {
		return ok(paymentMethodService.getAllPaymentMethods());
	}

	@GetMapping("/list/pageable")
	@Override
	public RootEntity<RestPageableEntity<DtoPaymentMethod>> getPageableResponse(RestPageableRequest pageable) {
		return ok(paymentMethodService.getPageableResponse(pageable));
	}

}
