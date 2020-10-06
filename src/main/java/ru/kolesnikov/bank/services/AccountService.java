package ru.kolesnikov.bank.services;

import ru.kolesnikov.bank.models.account.Account;

public interface AccountService {
    Account create(Account newAccount);
    Account[] getAll();
    Account getById(Integer id);
    Account updateById(Integer id, Account newAccount);
    Account deleteById(Integer id);
}
