package com.cognixia.jump.menu;

import java.text.SimpleDateFormat;

import com.cognixia.jump.form.DepositForm;
import com.cognixia.jump.form.SendTransferForm;
import com.cognixia.jump.form.WithdrawalForm;
import com.cognixia.jump.model.Account;
import com.cognixia.jump.utility.Colors;
import com.cognixia.jump.utility.display.TransactionDisplay;

public class AccountMenu extends Menu {
	
	AccountMenu(Account account) {
		super(
				getOptions(account),
				account.toString().toUpperCase(),
				getSubtitle(account));
	}
	
	private static MenuOption[] getOptions(Account account) {
		
		boolean hasBalance = account.getBalance().getAmountInCents() > 0;
		int nextIndex = 0;
		
		MenuOption[] options = new MenuOption[hasBalance ? 5 : 3];
		
		options[nextIndex++] = new MenuOption( // 1
				"Back to Main Menu", new MainMenu()::run);
		options[nextIndex++] = new MenuOption(
				"Deposit", new DepositForm(account)::run); // 2
		if (hasBalance) {
			options[nextIndex++] = new MenuOption( // (+1)
					"Withdrawal", new WithdrawalForm(account)::run);
			options[nextIndex++] = new MenuOption( // (+2)
					"Send Transfer", new SendTransferForm(account)::run);
		}
		options[nextIndex++] = new MenuOption( // 3
				"Recent Transactions", () -> {
					TransactionDisplay.printRecentTransactions(
							account.getTransactions(), account.toString());
					new AccountMenu(account).run();
				});
		
		return options;
	}
	
	private static String getSubtitle(Account account) {
		return 
				Colors.WHITE.colorize("Balance:") +
				Colors.GREEN.colorize(" " + account.getBalance()) +
				Colors.YELLOW.colorize(" -- ") +
				Colors.WHITE.colorize("Opened on: ") +
				Colors.YELLOW.colorize(new SimpleDateFormat("yyyy-MM-dd").format(account.getDateOpened()));
	}
	
}
