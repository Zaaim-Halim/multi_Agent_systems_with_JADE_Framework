package com.halim;

import java.io.Serializable;

public class Money implements Serializable{

	private static final long serialVersionUID = 1L;
	private Double amount;
	private String devise;
	public Money(Double amount, String devise) {
		super();
		this.amount = amount;
		this.devise = devise;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDevise() {
		return devise;
	}
	public void setDevise(String devise) {
		this.devise = devise;
	}
	@Override
	public String toString() {
		return "Money [amount=" + amount + ", devise=" + devise + "]";
	}
	

}
