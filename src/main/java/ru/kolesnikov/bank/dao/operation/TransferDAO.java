package ru.kolesnikov.bank.dao.operation;

import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.database.operation.TransferData;
import ru.kolesnikov.bank.models.operation.Transfer;

public class TransferDAO implements DAO<Transfer, Integer> {

    public final TransferData transferData;

    public TransferDAO(TransferData transferData) {
        this.transferData = transferData;
    }

    @Override
    public Transfer create(Transfer newTransfer) {
        return transferData.create(newTransfer);
    }

    @Override
    public Transfer[] getAll() {
        return transferData.getAll();
    }

    @Override
    public Transfer getById(Integer id) {
        return transferData.getById(id);
    }

    @Override
    public Transfer updateById(Integer id, Transfer newTransfer) {
        return transferData.updateById(id, newTransfer);
    }

    @Override
    public Transfer deleteById(Integer id) {
        return transferData.deleteById(id);
    }
}
