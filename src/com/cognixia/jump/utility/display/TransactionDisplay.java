package com.cognixia.jump.utility.display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.model.Transaction;
import com.cognixia.jump.model.Transaction.TransactionTypes;
import com.cognixia.jump.utility.Colors;

public class TransactionDisplay {
	
	private static final int DEFAULT_COUNT = 5;

	// there is no use for instance, so don't confuse developer by allowing instantiation
	private TransactionDisplay() {}
	
	public static void printRecentTransactions(List<Transaction> transactions) {
		printRecentTransactions(transactions, DEFAULT_COUNT);
	}
	public static void printRecentTransactions(List<Transaction> transactions, String listname) {
		printRecentTransactions(transactions, DEFAULT_COUNT, listname);
	}
	public static void printRecentTransactions(List<Transaction> transactions, int count) {
		printRecentTransactions(transactions, count, null);
	}
	
	public static void printRecentTransactions(
			List<Transaction> transactions, int count, String listName) {
		
		Display.printDivider();
		
		String heading = "RECENT TRANSACTIONS";
		if (listName != null) heading += " -- " + listName.toUpperCase();
		System.out.println(heading + "\n");
		
		int countToDisplay = Math.min(count, transactions.size());
		
		String message = countToDisplay > 0 ?
				"Showing " + countToDisplay + " of " + transactions.size() :
				"No transactions found.";
		System.out.println(Colors.YELLOW.colorize(message));
		
		getRecentTransactions(transactions, countToDisplay)
				.stream().forEach(TransactionDisplay::printTransaction);
	}
	
	private static List<Transaction> getRecentTransactions(List<Transaction> transactions, int countToDisplay) {
		// assume list is in chronological order. this should always be true.
		List<Transaction> recentTransactions = new ArrayList<>();
		for (int i = 0; i < countToDisplay; i++) {
			int bigListIndex = transactions.size() - 1 - i;
			if (bigListIndex < 0) break;
			recentTransactions.add(transactions.get(bigListIndex));
		}
		return recentTransactions;
	}
	
	public static void printTransaction(Transaction transaction) {
		printTransaction(transaction, true);
	}
	public static void printTransaction(Transaction transaction, boolean shouldPrintAccount) {
		System.out.println(Colors.WHITE.colorize(
				new SimpleDateFormat("yyyy-MM-dd hh:mm a z").format(transaction.getTimestamp())));
		String indent = "  ";
		Colors transTypeTheme = getColor(transaction);
		System.out.println(
				indent + transTypeTheme.colorize("Transaction " + transaction.getDisplayId()) +
				Colors.WHITE.colorize(" -- " + transaction.getType().toString()));
		System.out.println(transTypeTheme.colorize(
				indent + ""));
	}
	
	private static boolean isPositive(Transaction transaction) {
		TransactionTypes type = transaction.getType();
		return type == TransactionTypes.DEPOSIT || type == TransactionTypes.RECEIVE_TRANSFER;
	}
	
	public static Colors getColor(Transaction transaction) {
		return isPositive(transaction) ? Colors.GREEN : Colors.YELLOW;
	}
	
}
