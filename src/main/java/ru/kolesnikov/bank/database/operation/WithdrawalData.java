package ru.kolesnikov.bank.database.operation;

import ru.kolesnikov.bank.database.Data;
import ru.kolesnikov.bank.database.utils.DateUtils;
import ru.kolesnikov.bank.models.operation.Withdrawal;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class WithdrawalData implements Data<Withdrawal, Integer> {

    private final Map<Integer, Withdrawal> WITHDRAWALS;

    private final AtomicInteger lastId = new AtomicInteger(0);

    public WithdrawalData(Map<Integer, Withdrawal> WITHDRAWALS) {
        this.WITHDRAWALS = WITHDRAWALS;
    }

    @Override
    public Withdrawal create(Withdrawal newWithdrawal) {
        int newId = lastId.incrementAndGet();
        newWithdrawal.setId(newId);
        newWithdrawal.setDate(DateUtils.getCurrentDate());
        WITHDRAWALS.put(newId, newWithdrawal);
        return newWithdrawal;
    }

    @Override
    public Withdrawal[] getAll() {
        return WITHDRAWALS.values().toArray(new Withdrawal[0]);
    }

    @Override
    public Withdrawal getById(Integer id) {
        return WITHDRAWALS.get(id);
    }

    @Override
    public Withdrawal updateById(Integer id, Withdrawal newWithdrawal) {
        return WITHDRAWALS.replace(id, newWithdrawal);
    }

    @Override
    public Withdrawal deleteById(Integer id) {
        return WITHDRAWALS.remove(id);
    }
}
