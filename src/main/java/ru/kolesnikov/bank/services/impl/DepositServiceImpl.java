package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.account.AccountDAO;
import ru.kolesnikov.bank.dao.operation.DepositDAO;
import ru.kolesnikov.bank.models.operation.Deposit;
import ru.kolesnikov.bank.services.DepositService;

public class DepositServiceImpl implements DepositService {

    private final DepositDAO depositDAO;

    public DepositServiceImpl(DepositDAO depositDAO) {
        this.depositDAO = depositDAO;
    }

    @Override
    public Deposit create(Deposit newDeposit) {
        return depositDAO.create(newDeposit);
    }

    @Override
    public Deposit[] getAll() {
        return depositDAO.getAll();
    }

    @Override
    public Deposit getById(Integer id) {
        return depositDAO.getById(id);
    }

    @Override
    public Deposit updateById(Integer id, Deposit newDeposit) {
        return depositDAO.updateById(id, newDeposit);
    }

    @Override
    public Deposit deleteById(Integer id) {
        return depositDAO.deleteById(id);
    }
}
