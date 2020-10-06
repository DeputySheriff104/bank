package ru.kolesnikov.bank.services;

import ru.kolesnikov.bank.models.operation.Withdrawal;

public interface WithdrawalService {
    Withdrawal create(Withdrawal newWithdrawal);
    Withdrawal[] getAll();
    Withdrawal getById(Integer id);
    Withdrawal updateById(Integer id, Withdrawal newWithdrawal);
    Withdrawal deleteById(Integer id);
}
