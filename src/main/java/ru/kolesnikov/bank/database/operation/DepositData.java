package ru.kolesnikov.bank.database.operation;

import ru.kolesnikov.bank.database.Data;
import ru.kolesnikov.bank.database.utils.DateUtils;
import ru.kolesnikov.bank.models.operation.Deposit;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DepositData implements Data<Deposit, Integer> {

    private final Map<Integer, Deposit> DEPOSITS;

    private final AtomicInteger lastId = new AtomicInteger(0);

    public DepositData(Map<Integer, Deposit> DEPOSITS) {
        this.DEPOSITS = DEPOSITS;
    }

    @Override
    public Deposit create(Deposit newDeposit) {
        int newId = lastId.incrementAndGet();
        newDeposit.setId(newId);
        newDeposit.setDate(DateUtils.getCurrentDate());
        DEPOSITS.put(newId, newDeposit);
        return newDeposit;
    }

    @Override
    public Deposit[] getAll() {
        return DEPOSITS.values().toArray(new Deposit[0]);
    }

    @Override
    public Deposit getById(Integer id) {
        return DEPOSITS.get(id);
    }

    @Override
    public Deposit updateById(Integer id, Deposit newDeposit) {
        return DEPOSITS.replace(id, newDeposit);
    }

    @Override
    public Deposit deleteById(Integer id) {
        return DEPOSITS.remove(id);
    }
}
