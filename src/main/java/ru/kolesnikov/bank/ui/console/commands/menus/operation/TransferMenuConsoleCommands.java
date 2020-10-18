package ru.kolesnikov.bank.ui.console.commands.menus.operation;

import ru.kolesnikov.bank.dao.entities.operation.TransferDAOImpl;
import ru.kolesnikov.bank.models.operation.Transfer;
import ru.kolesnikov.bank.services.impl.TransferServiceImpl;
import ru.kolesnikov.bank.ui.console.output.TransferConsoleOutput;
import ru.kolesnikov.bank.ui.console.utils.TransferUtils;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class TransferMenuConsoleCommands {

    private static final TransferServiceImpl transferService =
            new TransferServiceImpl(
                    new TransferDAOImpl());

    public static void create(Transfer newTransfer) {
        transferService.create(newTransfer);
    }

    public static void createFromConsoleInput() {
        Transfer newTransfer = new Transfer();
        TransferUtils.setTransferAttributes(newTransfer);
        create(newTransfer);
    }

    public static void outputAll() {
        System.out.println("All transfers:\n" +
                TransferConsoleOutput.getStringTransferAttributes() +
                TransferConsoleOutput.transfersToString(transferService.getAll()));
    }

    public static void outputById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        System.out.println(TransferConsoleOutput.transferToString(transferService.getById(id)));
    }

    public static void updateById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        Transfer newTransfer = new Transfer();
        newTransfer.setId(id);
        TransferUtils.setTransferAttributes(newTransfer);
        transferService.updateById(id, newTransfer);
    }

    public static void deleteById() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        transferService.deleteById(id);
    }
}
