package com.salt.pepper.currencycoverterservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salt.pepper.currencycoverterservice.delegate.CurrencyValueServiceDelegate;
import com.salt.pepper.currencycoverterservice.dto.Currency;
import com.salt.pepper.currencycoverterservice.exception.NotAValidCurrencyException;
import com.salt.pepper.currencycoverterservice.service.CurrencyConverterDao;

@Service
public class CurrencyConverterService {
	
	@Autowired
	CurrencyConverterDao dao;
	
	@Autowired
	CurrencyValueServiceDelegate delegate;
	
	public Currency convertCurrency(Currency curr) throws NotAValidCurrencyException {
		//int toCurrencyValue = dao.getCurrencyValue(curr.getToCurrencyType());
		int toBeConverted = curr.getCurrencyToBeConverted();
		curr = delegate.convert(curr.getFromCurrencyType(), curr.getToCurrencyType());
		curr.setCurrencyToBeConverted(toBeConverted);
		System.out.println("------------>"+curr);
		/*
		 * if(toCurrencyValue == 0) { throw new
		 * NotAValidCurrencyException("Currency "+curr+ "Is not a valid currency"); }
		 */
		curr.setConvertedValue(curr.getCurrencyValue() * curr.getCurrencyToBeConverted());
		return curr; 
	}

}
