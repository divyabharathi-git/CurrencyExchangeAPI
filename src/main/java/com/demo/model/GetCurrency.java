package com.demo.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GetCurrency {
	
	@JsonIgnore
	private String currency;
	@JsonIgnore
	private double rate;	
	private String base;
	private Map<String,Double> currencies;

	
	public GetCurrency(String currency, double rate, String base) {
		super();
		this.currency = currency;
		this.rate = rate;
		this.base = base;
	}

	public GetCurrency() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}

	public Map<String, Double> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Map<String, Double> currencies) {
		this.currencies = currencies;
	}

	
	

}
