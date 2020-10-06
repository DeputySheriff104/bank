package ru.kolesnikov.bank.services;

import ru.kolesnikov.bank.models.operation.Transfer;

public interface TransferService {
    Transfer create(Transfer newTransfer);
    Transfer[] getAll();
    Transfer getById(Integer id);
    Transfer updateById(Integer id, Transfer newTransfer);
    Transfer deleteById(Integer id);
}
