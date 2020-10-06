package ru.kolesnikov.bank.ui.console.output;

import ru.kolesnikov.bank.models.operation.Withdrawal;
import ru.kolesnikov.bank.ui.console.output.options.ConsoleColors;

public class WithdrawalConsoleOutput {

    public static String withdrawalsToString(Withdrawal[] withdrawals) {
        StringBuilder output = new StringBuilder();
        for (Withdrawal withdrawal: withdrawals) {
            output.append(withdrawalToString(withdrawal));
        }
        return output.toString();
    }

    public static String withdrawalToString(Withdrawal withdrawal) {
        return String.format(ConsoleColors.BLUE + "%-5s%-15s%-15s%-25s%n"+ ConsoleColors.RESET,
                withdrawal.getId(),
                withdrawal.getFromAccountId(),
                withdrawal.getMoneyAmount(),
                withdrawal.getDate()
        );
    }

    public static String getStringWithdrawalAttributes() {
        return String.format("%-5s%-15s%-15s%-25s%n",
                "id",
                "fromAccountId",
                "moneyAmount",
                "date"
        );
    }
}
