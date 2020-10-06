package ru.kolesnikov.bank.ui.console.utils;

public class BootUtils {

    public static void createDefaultData() {
        UserUtils.createDefaultUsers();
        AccountUtils.createDefaultAccounts();
        TransferUtils.createDefaultTransfers();
        DepositUtils.createDefaultDeposits();
        WithdrawalUtils.createDefaultWithdrawals();
    }
}
