package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.model.Currency;
import com.demo.repository.CurrencyRepository;

@Transactional
@Service
public class CurrencyService {
	
	@Autowired  
	CurrencyRepository currencyRepository;
	
	public List<Currency> getAllCurrencies(String baseCcy)   
	{  
	List<Currency> currencies = new ArrayList<Currency>();  
	currencyRepository.findAllCurrencies(baseCcy).forEach(currency -> currencies.add(currency));  
	return currencies;  
	} 
	
	 public double getConvertedAmount(String toCurrency, String baseCcy)   
	{  
	double rate = currencyRepository.getConvertedAmount(toCurrency,baseCcy);  
	return rate;  
	} 
}
