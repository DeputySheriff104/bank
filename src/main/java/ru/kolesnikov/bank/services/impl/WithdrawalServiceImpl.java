package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.operation.WithdrawalDAO;
import ru.kolesnikov.bank.models.operation.Withdrawal;
import ru.kolesnikov.bank.services.WithdrawalService;

public class WithdrawalServiceImpl implements WithdrawalService {

    private final WithdrawalDAO withdrawalDAO;

    public WithdrawalServiceImpl(WithdrawalDAO withdrawalDAO) {
        this.withdrawalDAO = withdrawalDAO;
    }

    @Override
    public Withdrawal create(Withdrawal newWithdrawal) {
        return withdrawalDAO.create(newWithdrawal);
    }

    @Override
    public Withdrawal[] getAll() {
        return withdrawalDAO.getAll();
    }

    @Override
    public Withdrawal getById(Integer id) {
        return withdrawalDAO.getById(id);
    }

    @Override
    public Withdrawal updateById(Integer id, Withdrawal newWithdrawal) {
        return withdrawalDAO.updateById(id, newWithdrawal);
    }

    @Override
    public Withdrawal deleteById(Integer id) {
        return withdrawalDAO.deleteById(id);
    }
}
