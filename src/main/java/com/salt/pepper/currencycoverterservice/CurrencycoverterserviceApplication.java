package com.salt.pepper.currencycoverterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencycoverterserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencycoverterserviceApplication.class, args);
	}

}
