package com.usc.uscphoto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.usc.uscphoto.entity")
//@EnableJpaRepositories(basePackages = "com.usc.uscphoto.repository")
public class UscphotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UscphotoApplication.class, args);
	}

}
