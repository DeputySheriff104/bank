package ru.kolesnikov.bank.ui.console.commands.menus.user;

import ru.kolesnikov.bank.dao.user.UserDAO;
import ru.kolesnikov.bank.database.user.UserData;
import ru.kolesnikov.bank.models.user.User;
import ru.kolesnikov.bank.services.impl.UserServiceImpl;
import ru.kolesnikov.bank.ui.console.output.UserConsoleOutput;
import ru.kolesnikov.bank.ui.console.utils.UserUtils;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class UserMenuConsoleCommands {

    private static final UserServiceImpl userService =
            new UserServiceImpl(
                    new UserDAO(
                            new UserData(
                                    new ConcurrentHashMap<>())));

    public static void create(User newUser) {
        userService.create(newUser);
    }

    public static void createFromConsoleInput() {
        User newUser = new User();
        Scanner sc = new Scanner(System.in);
        UserUtils.setUserAttributes(newUser);
        create(newUser);
    }

    public static void outputAll() {
        System.out.println("All users:\n" +
                UserConsoleOutput.getStringUserAttributes() +
                UserConsoleOutput.usersToString(userService.getAll()));
    }

    public static void outputById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.println(UserConsoleOutput.getStringUserAttributes() +
                UserConsoleOutput.userToString(userService.getById(id)));
    }

    public static void updateById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        User newUser = new User();
        newUser.setId(id);
        UserUtils.setUserAttributes(newUser);
        userService.updateById(id, newUser);
    }

    public static void deleteById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        userService.deleteById(id);
    }
}
