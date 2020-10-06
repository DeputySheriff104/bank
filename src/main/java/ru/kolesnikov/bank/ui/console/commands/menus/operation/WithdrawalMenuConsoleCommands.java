package ru.kolesnikov.bank.ui.console.commands.menus.operation;

import ru.kolesnikov.bank.dao.operation.WithdrawalDAO;
import ru.kolesnikov.bank.database.operation.WithdrawalData;
import ru.kolesnikov.bank.models.operation.Withdrawal;
import ru.kolesnikov.bank.services.impl.WithdrawalServiceImpl;
import ru.kolesnikov.bank.ui.console.output.WithdrawalConsoleOutput;
import ru.kolesnikov.bank.ui.console.utils.WithdrawalUtils;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class WithdrawalMenuConsoleCommands {

    private static final WithdrawalServiceImpl withdrawalService =
            new WithdrawalServiceImpl(
                    new WithdrawalDAO(
                            new WithdrawalData(
                                    new ConcurrentHashMap<>())));

    public static void create(Withdrawal newWithdrawal) {
        withdrawalService.create(newWithdrawal);
    }

    public static void createFromConsoleInput() {
        Withdrawal newWithdrawal = new Withdrawal();
        Scanner sc = new Scanner(System.in);
        WithdrawalUtils.setWithdrawalAttributes(newWithdrawal);
        create(newWithdrawal);
    }

    public static void outputAll() {
        System.out.println("All withdrawal:\n" +
                WithdrawalConsoleOutput.getStringWithdrawalAttributes() +
                WithdrawalConsoleOutput.withdrawalsToString(withdrawalService.getAll()));
    }

    public static void outputById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.println(WithdrawalConsoleOutput.withdrawalToString(withdrawalService.getById(id)));
    }

    public static void updateById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        Withdrawal newWithdrawal = new Withdrawal();
        newWithdrawal.setId(id);
        WithdrawalUtils.setWithdrawalAttributes(newWithdrawal);
        withdrawalService.updateById(id, newWithdrawal);
    }

    public static void deleteById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        withdrawalService.deleteById(id);
    }
}
