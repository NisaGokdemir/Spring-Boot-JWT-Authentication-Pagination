package com.gokdemir.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gokdemir.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	@Query(value = "from Payment")
	Page<Payment> findAllPageable(Pageable pageable);
}
