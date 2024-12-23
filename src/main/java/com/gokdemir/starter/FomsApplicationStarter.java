package com.gokdemir.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = {"com.gokdemir"})
@ComponentScan(basePackages = {"com.gokdemir"})
@EnableJpaRepositories(basePackages = {"com.gokdemir"}) 
@SpringBootApplication
public class FomsApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(FomsApplicationStarter.class, args);
	}

}
