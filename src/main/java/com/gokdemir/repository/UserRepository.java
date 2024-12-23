package com.gokdemir.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gokdemir.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
		//@Query(value = "from User where username = :username ")
		Optional<User> findByUsername(String username);
		
		@Query(value = "from User")
		Page<User> findAllPageable(Pageable pageable);
}
