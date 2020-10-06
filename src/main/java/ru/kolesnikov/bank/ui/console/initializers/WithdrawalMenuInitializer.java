package ru.kolesnikov.bank.ui.console.initializers;

import ru.kolesnikov.bank.ui.console.commands.menus.account.AccountMenuConsoleCommands;
import ru.kolesnikov.bank.ui.console.commands.menus.operation.WithdrawalMenuConsoleCommands;

import java.util.Scanner;

public class WithdrawalMenuInitializer {

    public void initialize() {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        int commandNumber;
        while (isRunning) {
            System.out.print("Withdrawals.\n" +
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
                    WithdrawalMenuConsoleCommands.outputAll();
                    break;
                }
                case 2: {
                    WithdrawalMenuConsoleCommands.outputById();
                    break;
                }
                case 3: {
                    WithdrawalMenuConsoleCommands.updateById();
                    break;
                }
                case 4: {
                    WithdrawalMenuConsoleCommands.createFromConsoleInput();
                    break;
                }
                case 5: {
                    WithdrawalMenuConsoleCommands.deleteById();
                    break;
                }
                default: {
                    System.out.println("Unknown command\n");
                }
            }
        }
    }
}
