package ru.kolesnikov.bank.services;

import ru.kolesnikov.bank.models.operation.Deposit;

public interface DepositService {
    Deposit create(Deposit newDeposit);
    Deposit[] getAll();
    Deposit getById(Integer id);
    Deposit updateById(Integer id, Deposit newDeposit);
    Deposit deleteById(Integer id);
}
