package com.cognixia.jump.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class DollarAmount implements Serializable {
	
	private static final long serialVersionUID = 1;
	
	private long amountInCents;
	
	public DollarAmount() {
		this(0);
	}
	
	public DollarAmount(long amountInCents) {
		try {
			setAmount(amountInCents);
//		} catch(InvalidDollarAmountException e) {
//			System.out.println("Invalid dollar amount. Dollar amount was not set.");
		} catch(Exception e) {
			System.out.println("Unexpected error occured while saving dollar amount.");
		}
	}
	
	public static DollarAmount getSum(DollarAmount dollarAmt1, DollarAmount dollarAmt2) {
		return new DollarAmount(dollarAmt1.getAmountInCents() + dollarAmt2.getAmountInCents());
	}
	
	public void add(DollarAmount amountToAdd) throws Exception {
		add(amountToAdd.amountInCents);
	}
	public void add(long amountInCents) throws Exception {
		setAmount(this.amountInCents + amountInCents);
	}
	public void subtract(DollarAmount amountToSubtract) throws Exception {
		add(0l - amountToSubtract.getAmountInCents());
	}
	
	public long getAmountInCents() {
		return amountInCents;
	}
	public void setAmount(long amount) throws Exception {
		if (amount < 0) throw new Exception();
		this.amountInCents = amount;
	}
	
	@Override
	public String toString() {
		String numericValueAsString = "" + amountInCents;
		while (numericValueAsString.length() < 3) {
			numericValueAsString = "0" + numericValueAsString;
		}
		numericValueAsString = // source: https://www.baeldung.com/java-add-character-to-string#using-a-stringbuilder
				new StringBuilder(numericValueAsString)
				.insert(numericValueAsString.length() - 2, '.')
				.toString();
		// source: https://www.baeldung.com/java-number-formatting
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		return nf.format(Double.parseDouble(numericValueAsString));
	}
	
}
