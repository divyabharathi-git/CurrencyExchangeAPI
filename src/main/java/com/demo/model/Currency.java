package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Currencies")
public class Currency {
	@Id
	@Column(name = "Ccy")
	private String currency;
	@Column(name = "Rate")
	private double rate;
	@Column(name = "Base")
	private String base;


	@Transient
	private String from;
	@Transient
	private String to;
	@Transient
	private double amount;
	@Transient
	private double convertedamount;
	@Transient
	private String datetime;
	
	
	
	public Currency(String currency, double rate, String base) {
		super();
		this.currency = currency;
		this.rate = rate;
		this.base = base;
	}

	public Currency() {
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

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getConvertedamount() {
		return convertedamount;
	}

	public void setConvertedamount(double convertedamount) {
		this.convertedamount = convertedamount;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String formattedDate) {
		this.datetime = formattedDate;
	}

	
	

	 

}
