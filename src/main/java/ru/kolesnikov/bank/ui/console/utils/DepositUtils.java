package ru.kolesnikov.bank.ui.console.utils;

import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.models.operation.Deposit;
import ru.kolesnikov.bank.ui.console.commands.menus.account.AccountMenuConsoleCommands;
import ru.kolesnikov.bank.ui.console.commands.menus.operation.DepositMenuConsoleCommands;

import java.util.Scanner;

public class DepositUtils {

    /*public static void createDefaultDeposits() {
        DepositMenuConsoleCommands.create(new Deposit(
                1,
                500)
        );
        DepositMenuConsoleCommands.create(new Deposit(
                2,
                750)
        );
    }*/

    public static void setDepositAttributes(Deposit newDeposit) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter to account id: ");
        newDeposit.setToAccountId(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter money amount: ");
        newDeposit.setMoneyAmount(Integer.parseInt(sc.nextLine()));
        System.out.println();
    }
}
