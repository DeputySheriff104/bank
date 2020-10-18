package ru.kolesnikov.bank.ui.console.commands.menus.operation;

import ru.kolesnikov.bank.dao.entities.operation.DepositDAOImpl;
import ru.kolesnikov.bank.models.operation.Deposit;
import ru.kolesnikov.bank.services.impl.DepositServiceImpl;
import ru.kolesnikov.bank.ui.console.output.DepositConsoleOutput;
import ru.kolesnikov.bank.ui.console.utils.DepositUtils;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class DepositMenuConsoleCommands {

    private static final DepositServiceImpl depositService =
            new DepositServiceImpl(
                    new DepositDAOImpl());

    public static void create(Deposit newDeposit) {
        depositService.create(newDeposit);
    }

    public static void createFromConsoleInput() {
        Deposit newDeposit = new Deposit();
        DepositUtils.setDepositAttributes(newDeposit);
        create(newDeposit);
    }

    public static void outputAll() {
        System.out.println("All deposits:\n" +
                DepositConsoleOutput.getStringDepositAttributes() +
                DepositConsoleOutput.depositsToString(depositService.getAll()));
    }

    public static void outputById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.println(DepositConsoleOutput.depositToString(depositService.getById(id)));
    }

    public static void updateById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        Deposit newDeposit = new Deposit();
        newDeposit.setId(id);
        DepositUtils.setDepositAttributes(newDeposit);
        depositService.updateById(id, newDeposit);
    }

    public static void deleteById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        depositService.deleteById(id);
    }
}
