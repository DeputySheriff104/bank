package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.entities.operation.DepositDAOImpl;
import ru.kolesnikov.bank.models.operation.Deposit;
import ru.kolesnikov.bank.services.Service;

import java.util.List;

public class DepositServiceImpl implements Service<Deposit, Integer> {

    private final DepositDAOImpl depositDAOImpl;

    public DepositServiceImpl(DepositDAOImpl depositDAOImpl) {
        this.depositDAOImpl = depositDAOImpl;
    }

    @Override
    public boolean create(Deposit newDeposit) {
        return depositDAOImpl.create(newDeposit);
    }

    @Override
    public List<Deposit> getAll() {
        return depositDAOImpl.getAll();
    }

    @Override
    public Deposit getById(Integer id) {
        return depositDAOImpl.getById(id);
    }

    @Override
    public boolean updateById(Integer id, Deposit newDeposit) {
        return depositDAOImpl.updateById(id, newDeposit);
    }

    @Override
    public boolean deleteById(Integer id) {
        return depositDAOImpl.deleteById(id);
    }
}
