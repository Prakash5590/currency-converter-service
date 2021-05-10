package com.salt.pepper.currencycoverterservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.salt.pepper.currencycoverterservice.dto.Currency;
import com.salt.pepper.currencycoverterservice.exception.NotAValidCurrencyException;
import com.salt.pepper.currencycoverterservice.repository.CurrencyConverterService;

@RestController
public class CurrencyConverterController {
	
	@Autowired
	CurrencyConverterService service;
	
	@GetMapping("/convert/from/{from}/to/{to}/value/{value}")
	public ResponseEntity<Currency> convert(@PathVariable String from , @PathVariable String to, @PathVariable int value) throws NotAValidCurrencyException{
		System.out.println("In controller");
		Currency curr = new Currency(from , to, value,0,0,"");
		Currency updated = service.convertCurrency(curr);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
	}
	
}
