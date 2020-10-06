package ru.kolesnikov.bank.ui.console.commands.menus.main;

import ru.kolesnikov.bank.ui.console.initializers.*;

public class MainMenuConsoleCommands {

    public static void goToUsers() {
        UserMenuInitializer userMenuInitializer = new UserMenuInitializer();
        userMenuInitializer.initialize();
    }

    public static void goToAccounts() {
        AccountMenuInitializer accountMenuInitializer = new AccountMenuInitializer();
        accountMenuInitializer.initialize();
    }

    public static void goToTransfers() {
        TransferMenuInitializer transferMenuInitializer = new TransferMenuInitializer();
        transferMenuInitializer.initialize();
    }

    public static void goToDeposits() {
        DepositMenuInitializer depositMenuInitializer = new DepositMenuInitializer();
        depositMenuInitializer.initialize();
    }

    public static void goToWithdrawals() {
        WithdrawalMenuInitializer withdrawalMenuInitializer = new WithdrawalMenuInitializer();
        withdrawalMenuInitializer.initialize();
    }
}
