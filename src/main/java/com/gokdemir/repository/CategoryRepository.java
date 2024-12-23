package com.gokdemir.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gokdemir.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query(value = "from Category")
	Page<Category> findAllPageable(Pageable pageable);
}
