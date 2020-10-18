package ru.kolesnikov.bank.ui.console.utils;

import ru.kolesnikov.bank.models.user.User;
import ru.kolesnikov.bank.ui.console.commands.menus.user.UserMenuConsoleCommands;

import java.util.Scanner;

public class UserUtils {

    /*public static void createDefaultUsers() {
        UserMenuConsoleCommands.create(new User(
                "login1",
                "pass1",
                "Larry",
                "Lawton",
                "79507718178",
                "prison@gmail.com")
        );
        UserMenuConsoleCommands.create(new User(
                "login2",
                "pass2",
                "Anthony",
                "Soprano",
                "79047718178",
                "omerta@gmail.com")
        );
    }*/

    public static void setUserAttributes(User newUser) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter login: ");
        newUser.setLogin(sc.nextLine());
        System.out.print("Enter password: ");
        newUser.setPassword(sc.nextLine());
        System.out.print("Enter first name: ");
        newUser.setFirstName(sc.nextLine());
        System.out.print("Enter last name: ");
        newUser.setLastName(sc.nextLine());
        System.out.print("Enter phone: ");
        newUser.setPhone(sc.nextLine());
        System.out.print("Enter email: ");
        newUser.setEmail(sc.nextLine());
        System.out.println();
    }
}
