package com.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.ConvertCurrency;
import com.demo.model.GetCurrency;
import com.demo.service.CurrencyService;



@Transactional
@RestController
public class CurrencyController {
	
	@Autowired  
	CurrencyService currencyService; 
	
	//By default it shows currencies and rates against USD(BaseCurency)
	//URL : localhost:8081/allCurrencies?
	//URL : localhost:8081/allCurrencies?base=EUR
	@GetMapping("/allCurrencies")  
	private GetCurrency getAllCurrencies(@RequestParam(defaultValue = "USD") String base)   
	{  
		List<GetCurrency> currencies = new ArrayList<>();
		currencies = currencyService.getAllCurrencies(base);
		
		GetCurrency gc = new GetCurrency();
		
		gc.setBase(base);
		gc.setCurrencies(currencies.stream().collect(Collectors.toMap(GetCurrency::getCurrency, GetCurrency::getRate)));

		return gc;
	}  
	
	//By default it calclates currencies and rates against USD(BaseCurency)
	//URL : localhost:8081/currencyConvertor/?from=INR&to=AED&amount=2
	//URL : localhost:8081/currencyConvertor/?from=INR&to=AED&amount=2&base=USD
	@GetMapping("/currencyConvertor")  
	private ConvertCurrency getConvertedAmount(@RequestParam Map<String, String> params)  
	{  
		String strDateFormat = "dd-MM-yyyy HH:mm:ss";
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);	
		
		String fromCurrency = params.get("from");
		String toCurrency = params.get("to");
		String baseCcy = params.get("base");
		if(baseCcy == null || baseCcy.isEmpty()) {
			baseCcy = "USD";
		}
		
		double amount = Double.valueOf(params.get("amount"));
		double rate =  currencyService.getConvertedAmount(toCurrency,baseCcy);
		
		double convertedAmount = amount * rate;
		
		ConvertCurrency cc = new ConvertCurrency();
		
		cc.setDatetime(formattedDate);
		cc.setBase(baseCcy);
		cc.setFrom(fromCurrency);
		cc.setTo(toCurrency);
		cc.setRate(rate);
		cc.setAmount(amount);
		cc.setConvertedamount(convertedAmount);
		
	
		return cc;  
	} 
}



