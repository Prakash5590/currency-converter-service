package com.salt.pepper.currencycoverterservice.delegate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salt.pepper.currencycoverterservice.dto.Currency;

//@FeignClient(name = "Currency-Value-Service" ,url = "localhost:8000")
@FeignClient(name = "currency-value-service" )
public interface CurrencyValueServiceDelegate {
	
	@GetMapping("/retrieve/from/{from}/to/{to}")
	public Currency convert(@PathVariable String from , @PathVariable String to);

}
