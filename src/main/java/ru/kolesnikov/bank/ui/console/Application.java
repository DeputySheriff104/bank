package ru.kolesnikov.bank.ui.console;

import ru.kolesnikov.bank.ui.console.initializers.MainMenuInitializer;
import ru.kolesnikov.bank.ui.console.utils.BootUtils;

public class Application {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BootUtils.createDefaultData();
        MainMenuInitializer mainMenuInitializer = new MainMenuInitializer();
        mainMenuInitializer.initialize();
    }
}
