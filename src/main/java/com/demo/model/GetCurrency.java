package com.demo.model;

public class GetCurrency {
	
	
	private String currency;
	private double rate;	
	private String base;

	
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

	
	

}
