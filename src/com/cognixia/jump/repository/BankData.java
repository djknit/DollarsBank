package com.cognixia.jump.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.model.Patron;

// singleton
public class BankData implements Serializable {

	private static final long serialVersionUID = 1L;
	private static BankData instance;
	
	private List<Patron> patrons;
	
	private BankData() {
		super();
		patrons = new ArrayList<Patron>();
	}
	
	public static BankData getInstance() {
		return instance;
	}
	
	// These methods could be instance methods instead, but static methods can be used on instance as well with additional convenience of allowing option to skip step of calling getInstance.
	public static List<Patron> getPatrons() {
		return instance.patrons;
	}
	public static void addPatron(Patron patron) {
		instance.patrons.add(patron);
	}
	public static void removePatron(Patron patron) {
		instance.patrons.remove(patron);
	}

}
