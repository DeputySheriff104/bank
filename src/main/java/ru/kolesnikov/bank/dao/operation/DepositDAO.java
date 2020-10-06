package ru.kolesnikov.bank.dao.operation;

import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.database.operation.DepositData;
import ru.kolesnikov.bank.models.operation.Deposit;

public class DepositDAO implements DAO<Deposit, Integer> {

    public final DepositData depositData;

    public DepositDAO(DepositData depositData) {
        this.depositData = depositData;
    }

    @Override
    public Deposit create(Deposit newDeposit) {
        return depositData.create(newDeposit);
    }

    @Override
    public Deposit[] getAll() {
        return depositData.getAll();
    }

    @Override
    public Deposit getById(Integer id) {
        return depositData.getById(id);
    }

    @Override
    public Deposit updateById(Integer id, Deposit newDeposit) {
        return depositData.updateById(id, newDeposit);
    }

    @Override
    public Deposit deleteById(Integer id) {
        return depositData.deleteById(id);
    }
}
