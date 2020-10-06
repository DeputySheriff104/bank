package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.operation.TransferDAO;
import ru.kolesnikov.bank.models.operation.Transfer;
import ru.kolesnikov.bank.services.TransferService;

public class TransferServiceImpl implements TransferService {

    private final TransferDAO transferDAO;

    public TransferServiceImpl(TransferDAO transferDAO) {
        this.transferDAO = transferDAO;
    }

    @Override
    public Transfer create(Transfer newTransfer) {
        return transferDAO.create(newTransfer);
    }

    @Override
    public Transfer[] getAll() {
        return transferDAO.getAll();
    }

    @Override
    public Transfer getById(Integer id) {
        return transferDAO.getById(id);
    }

    @Override
    public Transfer updateById(Integer id, Transfer newTransfer) {
        return transferDAO.updateById(id, newTransfer);
    }

    @Override
    public Transfer deleteById(Integer id) {
        return transferDAO.deleteById(id);
    }
}
