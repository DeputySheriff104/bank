package ru.kolesnikov.bank.ui.console.initializers;

import ru.kolesnikov.bank.ui.console.commands.menus.account.AccountMenuConsoleCommands;
import ru.kolesnikov.bank.ui.console.commands.menus.operation.TransferMenuConsoleCommands;

import java.util.Scanner;

public class TransferMenuInitializer {

    public void initialize() {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        int commandNumber;
        while (isRunning) {
            System.out.print("Transfers.\n" +
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
                    TransferMenuConsoleCommands.outputAll();
                    break;
                }
                case 2: {
                    TransferMenuConsoleCommands.outputById();
                    break;
                }
                case 3: {
                    TransferMenuConsoleCommands.updateById();
                    break;
                }
                case 4: {
                    TransferMenuConsoleCommands.createFromConsoleInput();
                    break;
                }
                case 5: {
                    TransferMenuConsoleCommands.deleteById();
                    break;
                }
                default: {
                    System.out.println("Unknown command\n");
                }
            }
        }
    }
}
