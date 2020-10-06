package ru.kolesnikov.bank.database.operation;

import ru.kolesnikov.bank.database.Data;
import ru.kolesnikov.bank.database.utils.DateUtils;
import ru.kolesnikov.bank.models.operation.Transfer;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TransferData implements Data<Transfer, Integer> {

    private final Map<Integer, Transfer> TRANSFERS;

    private final AtomicInteger lastId = new AtomicInteger(0);

    public TransferData(Map<Integer, Transfer> TRANSFERS) {
        this.TRANSFERS = TRANSFERS;
    }

    @Override
    public Transfer create(Transfer newTransfer) {
        int newId = lastId.incrementAndGet();
        newTransfer.setId(newId);
        newTransfer.setDate(DateUtils.getCurrentDate());
        TRANSFERS.put(newId, newTransfer);
        return newTransfer;
    }

    @Override
    public Transfer[] getAll() {
        return TRANSFERS.values().toArray(new Transfer[0]);
    }

    @Override
    public Transfer getById(Integer id) {
        return TRANSFERS.get(id);
    }

    @Override
    public Transfer updateById(Integer id, Transfer newTransfer) {
        return TRANSFERS.replace(id, newTransfer);
    }

    @Override
    public Transfer deleteById(Integer id) {
        return TRANSFERS.remove(id);
    }
}
