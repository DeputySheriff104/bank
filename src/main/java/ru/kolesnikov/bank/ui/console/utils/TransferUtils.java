package ru.kolesnikov.bank.ui.console.utils;

import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.models.operation.Deposit;
import ru.kolesnikov.bank.models.operation.Transfer;
import ru.kolesnikov.bank.ui.console.commands.menus.account.AccountMenuConsoleCommands;
import ru.kolesnikov.bank.ui.console.commands.menus.operation.DepositMenuConsoleCommands;
import ru.kolesnikov.bank.ui.console.commands.menus.operation.TransferMenuConsoleCommands;

import java.util.Scanner;

public class TransferUtils {

    /*public static void createDefaultTransfers() {
        TransferMenuConsoleCommands.create(new Transfer(
                1,
                2,
                250)
        );
        TransferMenuConsoleCommands.create(new Transfer(
                2,
                1,
                400)
        );
    }*/

    public static void setTransferAttributes(Transfer newTransfer) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter from account id: ");
        newTransfer.setFromAccountId(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter to account id: ");
        newTransfer.setToAccountId(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter money amount: ");
        newTransfer.setMoneyAmount(Integer.parseInt(sc.nextLine()));
        System.out.println();
    }
}
