package com.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Currency;
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
	private List<Currency> getAllCurrencies(@RequestParam(defaultValue = "USD") String base)   
	{  
		List<Currency> currencies = new ArrayList<>();
		currencies = currencyService.getAllCurrencies(base);
		return currencies;
	}  
	
	//By default it calclates currencies and rates against USD(BaseCurency)
	//URL : localhost:8081/currencyConvertor/?from=INR&to=AED&amount=2
	//URL : localhost:8081/currencyConvertor/?from=INR&to=AED&amount=2&base=USD
	@GetMapping("/currencyConvertor")  
	private Currency getConvertedAmount(@RequestParam Map<String, String> params)  
	{  
		String strDateFormat = "dd-MM-yyyy HH:mm:ss";
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);

		
		Currency c = new Currency();
		String fromCurrency = params.get("from");
		String toCurrency = params.get("to");
		String baseCcy = params.get("base");
		if(baseCcy == null || baseCcy.isEmpty()) {
			baseCcy = "USD";
		}
		
		double amount = Double.valueOf(params.get("amount"));
		double rate =  currencyService.getConvertedAmount(toCurrency,baseCcy);
		
		double convertedAmount = amount * rate;
		
		c.setDatetime(formattedDate);
		c.setBase(baseCcy);
		c.setFrom(fromCurrency);
		c.setTo(toCurrency);
		c.setRate(rate);
		c.setAmount(amount);
		c.setConvertedamount(convertedAmount);
		
		return c;  
	} 
}
