package com.paulo011.AGA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiGerenciamentoArmazemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGerenciamentoArmazemApplication.class, args);
	}

}
