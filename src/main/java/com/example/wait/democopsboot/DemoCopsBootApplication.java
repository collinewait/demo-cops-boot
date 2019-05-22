package com.example.wait.democopsboot;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.wait.orm.jpa.InMemoryUniqueIdGenerator;
import com.example.wait.orm.jpa.UniqueIdGenerator;

@SpringBootApplication
public class DemoCopsBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoCopsBootApplication.class, args);
	}
	
	@Bean
	  public UniqueIdGenerator<UUID> uniqueIdGenerator() {
	      return new InMemoryUniqueIdGenerator();
	}
}
