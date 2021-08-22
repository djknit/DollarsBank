package com.cognixia.jump.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.model.Account;
import com.cognixia.jump.model.Patron;
import com.cognixia.jump.model.Transaction;
import com.cognixia.jump.utility.FileIO;

// singleton
public class BankDataRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	private static BankDataRepository instance;
	
	private List<Patron> patrons = new ArrayList<>();
	private List<Transaction> transactions = new ArrayList<>();
	private List<Account> accounts = new ArrayList<>();
	private Long nextPatronId = 1L;
	private Long nextTransactionId = 1L;
	private Long nextAccountId = 1L;
	
	static {
		Object dataFromFile = FileIO.getObjectDataFromFile();
		instance = dataFromFile == null ?
				new BankDataRepository() :
				(BankDataRepository) dataFromFile;
	}
	
	private BankDataRepository() {
		super();
	}
	
	public static BankDataRepository getInstance() {
		return instance;
	}
	
/* 	NOTE:
 * 		These methods could be instance methods instead, but static methods can be used on instance as well
 * 		with additional convenience of allowing the option to skip step of calling getInstance.
*/
	public static List<Patron> getPatrons() {
		return instance.patrons;
	}
	public static void addPatron(Patron patron) {
		instance.patrons.add(patron);
		save();
	}
	public static void removePatron(Patron patron) {
		instance.patrons.remove(patron);
		save();
	}
	
	public static List<Transaction> getTransactions() {
		return instance.transactions;
	}
	public static void addTransaction(Transaction transaction) {
		instance.transactions.add(transaction);
		save();
	}
	// (transactions shouldn't be removed)

	public static List<Account> getAccounts() {
		return instance.accounts;
	}
	public static void addAccount(Account account) {
		instance.accounts.add(account);
		save();
	}
	public static void removeAccount(Account account) {
		instance.accounts.remove(account);
		save();
	}
	
	public static Long getNextPatronId() {
		return instance.nextPatronId++;
		// not calling save because it will be called when patron is added. (if not added, id not used so save is not necessary.)
	}
	public static Long getNextTransactionId() {
		return instance.nextTransactionId++;
	}
	public static Long getNextAccountId() {
		return instance.nextAccountId++;
	}
	
	public static void save() {
		FileIO.writeToFile(instance);
	}
	
}
