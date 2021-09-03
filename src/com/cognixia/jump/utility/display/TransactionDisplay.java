package com.cognixia.jump.utility.display;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.model.Account;
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
	public static void printRecentTransactions(
			List<Transaction> transactions, String listname) {
		printRecentTransactions(transactions, DEFAULT_COUNT, listname, true);
	}
	public static void printRecentTransactions(
			List<Transaction> transactions, String listname, boolean shouldPrintAccount) {
		printRecentTransactions(transactions, DEFAULT_COUNT, listname, shouldPrintAccount);
	}
	public static void printRecentTransactions(List<Transaction> transactions, int count) {
		printRecentTransactions(transactions, count, true);
	}
	public static void printRecentTransactions(
			List<Transaction> transactions, int count, boolean shouldPrntAccount) {
		printRecentTransactions(transactions, count, null, shouldPrntAccount);
	}
	
	public static void printRecentTransactions(
			List<Transaction> transactions, int count, String listName, boolean shouldPrintAccount) {
		
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
				.stream().forEach((transaction) -> {
					TransactionDisplay.printTransaction(transaction, shouldPrintAccount);
				});
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
		
		Colors white = Colors.WHITE;
		
		System.out.println(white.colorize(
				new SimpleDateFormat("yyyy-MM-dd hh:mm a z").format(transaction.getTimestamp())));
		
		String indent = "  ";
		String separator = Colors.YELLOW.colorize(" -- ");
		Colors transTypeTheme = getColor(transaction);
		
		String basicInfo = indent +
				transTypeTheme.colorize(transaction.getDisplayId()) +
				separator + white.colorize("" + transaction.getType());
		if (shouldPrintAccount) {
			Account account = transaction.getAccount();
			basicInfo +=
					separator + white.colorize(account.getDisplayId()) +
					" " + Colors.GREEN.colorize(account.getNickname());
		}
		System.out.println(basicInfo);
		
		System.out.println(transTypeTheme.colorize(
				indent + transaction.getAmount() + " " + getPastTenseAction(transaction)));
	}
	
	private static String getPastTenseAction(Transaction transaction) {
		switch (transaction.getType()) {
			case DEPOSIT:
				return "deposited";
			case WITHDRAWAL:
				return "withdrawn";
			case SEND_TRANSFER:
				return "transfered out of account to " + getOtherAccountText(transaction);
			case RECEIVE_TRANSFER:
				return "transfered into account from " + getOtherAccountText(transaction);
			default:
				return null;
		}
	}
	private static String getOtherAccountText(Transaction transaction) {
		Account otherAccount = transaction.getOtherAccount();
		if (otherAccount == null) return null;
		String otherAccountText = otherAccount.getDisplayId();
		if (otherAccount.getPatron() == transaction.getAccount().getPatron()) {
			otherAccountText += "";
		} else {
			otherAccountText += "";
		}
		return otherAccountText;
	}
	
	private static boolean isPositive(Transaction transaction) {
		TransactionTypes type = transaction.getType();
		return type == TransactionTypes.DEPOSIT || type == TransactionTypes.RECEIVE_TRANSFER;
	}
	
	public static Colors getColor(Transaction transaction) {
		return isPositive(transaction) ? Colors.GREEN : Colors.YELLOW;
	}
	
}
