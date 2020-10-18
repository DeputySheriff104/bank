package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.entities.operation.TransferDAOImpl;
import ru.kolesnikov.bank.models.operation.Transfer;
import ru.kolesnikov.bank.services.Service;

import java.util.List;

public class TransferServiceImpl implements Service<Transfer, Integer> {

    private final TransferDAOImpl transferDAOImpl;

    public TransferServiceImpl(TransferDAOImpl transferDAOImpl) {
        this.transferDAOImpl = transferDAOImpl;
    }

    @Override
    public boolean create(Transfer newTransfer) {
        return transferDAOImpl.create(newTransfer);
    }

    @Override
    public List<Transfer> getAll() {
        return transferDAOImpl.getAll();
    }

    @Override
    public Transfer getById(Integer id) {
        return transferDAOImpl.getById(id);
    }

    @Override
    public boolean updateById(Integer id, Transfer newTransfer) {
        return transferDAOImpl.updateById(id, newTransfer);
    }

    @Override
    public boolean deleteById(Integer id) {
        return transferDAOImpl.deleteById(id);
    }
}
