package ru.kolesnikov.bank.ui.console.initializers;

import ru.kolesnikov.bank.ui.console.commands.menus.main.MainMenuConsoleCommands;

import java.sql.SQLException;
import java.util.Scanner;

public class MainMenuInitializer {

    public void initialize() {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        int commandNumber;
        while (isRunning) {
            System.out.print("Main menu.\n" +
                    "Enter command:\n" +
                    "0 - exit\n" +
                    "1 - go to users\n" +
                    "2 - go to accounts\n" +
                    "3 - go to transfers\n" +
                    "4 - go to deposits\n" +
                    "5 - go to withdrawals\n");
            commandNumber = sc.nextInt();
            switch (commandNumber) {
                case 0: {
                    isRunning = false;
                    System.out.println("Shutting down... ");
                    break;
                }
                case 1: {
                    MainMenuConsoleCommands.goToUsers();
                    break;
                }
                case 2: {
                    MainMenuConsoleCommands.goToAccounts();
                    break;
                }
                case 3: {
                    MainMenuConsoleCommands.goToTransfers();
                    break;
                }
                case 4: {
                    MainMenuConsoleCommands.goToDeposits();
                    break;
                }
                case 5: {
                    MainMenuConsoleCommands.goToWithdrawals();
                    break;
                }
                default: {
                    System.out.println("Unknown command\n");
                }
            }
        }
    }
}
