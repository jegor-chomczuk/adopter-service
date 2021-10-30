package com.ironhack.adopterservice;

import com.ironhack.adopterservice.controller.AdopterRepository;
import com.ironhack.adopterservice.dao.Adopter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class AdopterServiceApplication {

	@Autowired
	private AdopterRepository adopterRepository;

	public static void main(String[] args) {
		SpringApplication.run(AdopterServiceApplication.class, args);
	}


	Adopter adopter1 = new Adopter(1l, "Tatiana", 3l);
	Adopter adopter2 = new Adopter(2l, "Sofia", 2l);


	@Bean
	InitializingBean createAnimals() {
		return () -> {
			adopterRepository.saveAll(List.of(adopter1, adopter2));
		};
	}
}
