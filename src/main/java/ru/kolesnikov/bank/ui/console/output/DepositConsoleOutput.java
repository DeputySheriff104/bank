package ru.kolesnikov.bank.ui.console.output;

import ru.kolesnikov.bank.models.operation.Deposit;
import ru.kolesnikov.bank.ui.console.output.options.ConsoleColors;

public class DepositConsoleOutput {

    public static String depositsToString(Deposit[] deposits) {
        StringBuilder output = new StringBuilder();
        for (Deposit deposit: deposits) {
            output.append(depositToString(deposit));
        }
        return output.toString();
    }

    public static String depositToString(Deposit deposit) {
        return String.format(ConsoleColors.BLUE + "%-5s%-15s%-15s%-25s%n"+ ConsoleColors.RESET,
                deposit.getId(),
                deposit.getToAccountId(),
                deposit.getMoneyAmount(),
                deposit.getDate()
        );
    }

    public static String getStringDepositAttributes() {
        return String.format("%-5s%-15s%-15s%-25s%n",
                "id",
                "toAccountId",
                "moneyAmount",
                "date"
        );
    }
}
