package com.salt.pepper.currencycoverterservice.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Currency {
	private String fromCurrencyType;
	private String toCurrencyType;
	private int currencyToBeConverted;
	private int convertedValue;
	private int currencyValue;
	private String instance;
	
}
