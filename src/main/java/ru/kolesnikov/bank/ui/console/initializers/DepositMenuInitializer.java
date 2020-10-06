package ru.kolesnikov.bank.ui.console.initializers;

import ru.kolesnikov.bank.ui.console.commands.menus.account.AccountMenuConsoleCommands;
import ru.kolesnikov.bank.ui.console.commands.menus.operation.DepositMenuConsoleCommands;

import java.util.Scanner;

public class DepositMenuInitializer {

    public void initialize() {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        int commandNumber;
        while (isRunning) {
            System.out.print("Deposits.\n" +
                    "Enter command:\n" +
                    "0 - go back to main menu\n" +
                    "1 - output all\n" +
                    "2 - output by id\n" +
                    "3 - update by id\n" +
                    "4 - create\n" +
                    "5 - delete\n");
            commandNumber = sc.nextInt();
            switch (commandNumber) {
                case 0: {
                    isRunning = false;
                    break;
                }
                case 1: {
                    DepositMenuConsoleCommands.outputAll();
                    break;
                }
                case 2: {
                    DepositMenuConsoleCommands.outputById();
                    break;
                }
                case 3: {
                    DepositMenuConsoleCommands.updateById();
                    break;
                }
                case 4: {
                    DepositMenuConsoleCommands.createFromConsoleInput();
                    break;
                }
                case 5: {
                    DepositMenuConsoleCommands.deleteById();
                    break;
                }
                default: {
                    System.out.println("Unknown command\n");
                }
            }
        }
    }
}
