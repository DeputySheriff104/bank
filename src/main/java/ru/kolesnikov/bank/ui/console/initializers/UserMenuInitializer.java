package ru.kolesnikov.bank.ui.console.initializers;

import ru.kolesnikov.bank.ui.console.commands.menus.user.UserMenuConsoleCommands;

import java.sql.SQLException;
import java.util.Scanner;

public class UserMenuInitializer {

    public void initialize() {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        int commandNumber;
        while (isRunning) {
            System.out.print("Users.\n" +
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
                    UserMenuConsoleCommands.outputAll();
                    break;
                }
                case 2: {
                    UserMenuConsoleCommands.outputById();
                    break;
                }
                case 3: {
                    UserMenuConsoleCommands.updateById();
                    break;
                }
                case 4: {
                    UserMenuConsoleCommands.createFromConsoleInput();
                    break;
                }
                case 5: {
                    UserMenuConsoleCommands.deleteById();
                    break;
                }
                default: {
                    System.out.println("Unknown command\n");
                }
            }
        }
    }
}
