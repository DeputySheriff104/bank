package ru.kolesnikov.bank.dao.operation;

import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.database.operation.WithdrawalData;
import ru.kolesnikov.bank.models.operation.Withdrawal;

public class WithdrawalDAO implements DAO<Withdrawal, Integer> {

    public final WithdrawalData withdrawalData;

    public WithdrawalDAO(WithdrawalData withdrawalData) {
        this.withdrawalData = withdrawalData;
    }

    @Override
    public Withdrawal create(Withdrawal newWithdrawal) {
        return withdrawalData.create(newWithdrawal);
    }

    @Override
    public Withdrawal[] getAll() {
        return withdrawalData.getAll();
    }

    @Override
    public Withdrawal getById(Integer id) {
        return withdrawalData.getById(id);
    }

    @Override
    public Withdrawal updateById(Integer id, Withdrawal newWithdrawal) {
        return withdrawalData.updateById(id, newWithdrawal); }

    @Override
    public Withdrawal deleteById(Integer id) {
        return withdrawalData.deleteById(id);
    }
}
