package ru.kolesnikov.bank.ui.console.output;

import ru.kolesnikov.bank.models.operation.Transfer;
import ru.kolesnikov.bank.ui.console.output.options.ConsoleColors;

import java.util.List;

public class TransferConsoleOutput {

    public static String transfersToString(List<Transfer> transfers) {
        StringBuilder output = new StringBuilder();
        for (Transfer transfer: transfers) {
            output.append(transferToString(transfer));
        }
        return output.toString();
    }

    public static String transferToString(Transfer transfer) {
        return String.format(ConsoleColors.BLUE + "%-5s%-15s%-15s%-15s%-25s%n"+ ConsoleColors.RESET,
                transfer.getId(),
                transfer.getFromAccountId(),
                transfer.getToAccountId(),
                transfer.getMoneyAmount(),
                transfer.getDate()
        );
    }

    public static String getStringTransferAttributes() {
        return String.format("%-5s%-15s%-15s%-15s%-25s%n",
                "id",
                "fromAccountId",
                "toAccountId",
                "moneyAmount",
                "date"
        );
    }
}
