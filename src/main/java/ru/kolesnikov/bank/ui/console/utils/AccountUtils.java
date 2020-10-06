package ru.kolesnikov.bank.ui.console.utils;

import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.ui.console.commands.menus.account.AccountMenuConsoleCommands;

import java.util.Scanner;

public class AccountUtils {

    public static void createDefaultAccounts() {
        AccountMenuConsoleCommands.create(new Account(
                1,
                "pass1",
                1000)
        );
        AccountMenuConsoleCommands.create(new Account(
                2,
                "pass2",
                2000)
        );
    }

    public static void setAccountAttributes(Account newAccount) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter user id: ");
        newAccount.setUserId(sc.nextInt());
        System.out.print("Enter password: ");
        newAccount.setPassword(sc.nextLine());
        System.out.print("Enter money amount: ");
        newAccount.setMoneyAmount(sc.nextInt());
        System.out.println();
    }
}
