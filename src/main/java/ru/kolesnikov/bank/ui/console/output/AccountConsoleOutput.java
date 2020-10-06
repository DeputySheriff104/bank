package ru.kolesnikov.bank.ui.console.output;

import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.ui.console.output.options.ConsoleColors;

public class AccountConsoleOutput {

    public static String accountsToString(Account[] accounts) {
        StringBuilder output = new StringBuilder();
        for (Account account: accounts) {
            output.append(accountToString(account));
        }
        return output.toString();
    }

    public static String accountToString(Account account) {
        return String.format(ConsoleColors.BLUE + "%-5s%-10s%-10s%-10s%n"+ ConsoleColors.RESET,
                account.getId(),
                account.getUserId(),
                account.getPassword(),
                account.getMoneyAmount()
        );
    }

    public static String getStringAccountAttributes() {
        return String.format("%-5s%-10s%-10s%-10s%n",
                "id",
                "userId",
                "password",
                "moneyAmount"
        );
    }
}
