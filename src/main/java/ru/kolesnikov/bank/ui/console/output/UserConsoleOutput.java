package ru.kolesnikov.bank.ui.console.output;

import ru.kolesnikov.bank.models.user.User;
import ru.kolesnikov.bank.ui.console.output.options.ConsoleColors;

public class UserConsoleOutput {

    public static String usersToString(User[] users) {
        StringBuilder output = new StringBuilder();
        for (User user: users) {
            output.append(userToString(user));
        }
        return output.toString();
    }

    public static String userToString(User user) {
        return String.format(ConsoleColors.BLUE + "%-5s%-15s%-15s%-15s%-15s%-15s%-20s%n" + ConsoleColors.RESET,
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail()
        );
    }

    public static String getStringUserAttributes() {
        return String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-20s%n",
                "id",
                "login",
                "password",
                "firstName",
                "lastName",
                "phone",
                "email"
        );
    }

}
