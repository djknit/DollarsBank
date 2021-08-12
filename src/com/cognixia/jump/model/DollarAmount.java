package com.cognixia.jump.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class DollarAmount implements Serializable {
	
	private static final long serialVersionUID = -3345047498511845421L;
	private int amount;
	
	public DollarAmount() {
		this(0); // source: https://stackoverflow.com/questions/285177/how-do-i-call-one-constructor-from-another-in-java#answer-15348070
	}
	
	public DollarAmount(int amount) {
		try {
			setAmount(amount);
//		} catch(InvalidDollarAmountException e) {
//			System.out.println("Invalid dollar amount. Dollar amount was not set.");
		} catch(Exception e) {
			System.out.println("Unexpected error occured while saving dollar amount.");
		}
	}
	
	public static DollarAmount getSum(DollarAmount dollarAmt1, DollarAmount dollarAmt2) {
		return new DollarAmount(dollarAmt1.getAmount() + dollarAmt2.getAmount());
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) throws Exception {
		if (amount < 0) throw new Exception();
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		// source: https://www.baeldung.com/java-number-formatting
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		return nf.format(amount);
	}
	
}
