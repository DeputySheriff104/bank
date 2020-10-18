package ru.kolesnikov.bank.ui.console.utils;

import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.models.operation.Deposit;
import ru.kolesnikov.bank.models.operation.Transfer;
import ru.kolesnikov.bank.models.operation.Withdrawal;
import ru.kolesnikov.bank.ui.console.commands.menus.account.AccountMenuConsoleCommands;
import ru.kolesnikov.bank.ui.console.commands.menus.operation.DepositMenuConsoleCommands;
import ru.kolesnikov.bank.ui.console.commands.menus.operation.WithdrawalMenuConsoleCommands;

import java.util.Scanner;

public class WithdrawalUtils {

    /*public static void createDefaultWithdrawals() {
        WithdrawalMenuConsoleCommands.create(new Withdrawal(
                1,
                300)
        );
        WithdrawalMenuConsoleCommands.create(new Withdrawal(
                2,
                600)
        );
    }*/

    public static void setWithdrawalAttributes(Withdrawal newWithdrawal) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter from account id: ");
        newWithdrawal.setFromAccountId(Integer.parseInt(sc.nextLine()));
        System.out.print("Enter money amount: ");
        newWithdrawal.setMoneyAmount(Integer.parseInt(sc.nextLine()));
        System.out.println();
    }
}
