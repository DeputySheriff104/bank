package ru.kolesnikov.bank.ui.console.commands.menus.account;

import ru.kolesnikov.bank.dao.account.AccountDAO;
import ru.kolesnikov.bank.database.account.AccountData;
import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.services.impl.AccountServiceImpl;
import ru.kolesnikov.bank.ui.console.output.AccountConsoleOutput;
import ru.kolesnikov.bank.ui.console.utils.AccountUtils;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class AccountMenuConsoleCommands {

    private static final AccountServiceImpl accountService =
            new AccountServiceImpl(
                    new AccountDAO(
                            new AccountData(
                                    new ConcurrentHashMap<>())));

    public static void create(Account newAccount) {
        accountService.create(newAccount);
    }

    public static void createFromConsoleInput() {
        Account newAccount = new Account();
        Scanner sc = new Scanner(System.in);
        AccountUtils.setAccountAttributes(newAccount);
        create(newAccount);
    }

    public static void outputAll() {
        System.out.println("All accounts:\n" +
                AccountConsoleOutput.getStringAccountAttributes() +
                AccountConsoleOutput.accountsToString(accountService.getAll()));
    }

    public static void outputById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.println(AccountConsoleOutput.accountToString(accountService.getById(id)));
    }

    public static void updateById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        Account newAccount = new Account();
        newAccount.setId(id);
        AccountUtils.setAccountAttributes(newAccount);
        accountService.updateById(id, newAccount);
    }

    public static void deleteById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        accountService.deleteById(id);
    }
}
