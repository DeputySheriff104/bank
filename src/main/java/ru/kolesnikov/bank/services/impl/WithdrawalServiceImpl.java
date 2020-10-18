package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.entities.operation.WithdrawalDAOImpl;
import ru.kolesnikov.bank.models.operation.Withdrawal;
import ru.kolesnikov.bank.services.Service;

import java.util.List;

public class WithdrawalServiceImpl implements Service<Withdrawal, Integer> {

    private final WithdrawalDAOImpl withdrawalDAOImpl;

    public WithdrawalServiceImpl(WithdrawalDAOImpl withdrawalDAOImpl) {
        this.withdrawalDAOImpl = withdrawalDAOImpl;
    }

    @Override
    public boolean create(Withdrawal newWithdrawal) {
        return withdrawalDAOImpl.create(newWithdrawal);
    }

    @Override
    public List<Withdrawal> getAll() {
        return withdrawalDAOImpl.getAll();
    }

    @Override
    public Withdrawal getById(Integer id) {
        return withdrawalDAOImpl.getById(id);
    }

    @Override
    public boolean updateById(Integer id, Withdrawal newWithdrawal) {
        return withdrawalDAOImpl.updateById(id, newWithdrawal);
    }

    @Override
    public boolean deleteById(Integer id) {
        return withdrawalDAOImpl.deleteById(id);
    }
}
