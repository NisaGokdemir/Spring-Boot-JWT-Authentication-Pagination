package com.gokdemir.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gokdemir.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	@Query(value = "from Order")
	Page<Order> findAllPageable(Pageable pageable);
}
