package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.entities.account.AccountDAOImpl;
import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.services.Service;

import java.util.List;

public class AccountServiceImpl implements Service<Account, Integer> {

    private final AccountDAOImpl accountDAOImpl;

    public AccountServiceImpl(AccountDAOImpl accountDAOImpl) {
        this.accountDAOImpl = accountDAOImpl;
    }

    @Override
    public boolean create(Account newAccount) {
        return accountDAOImpl.create(newAccount);
    }

    @Override
    public List<Account> getAll() {
        return accountDAOImpl.getAll();
    }

    @Override
    public Account getById(Integer id) {
        return accountDAOImpl.getById(id);
    }

    @Override
    public boolean updateById(Integer id, Account newAccount) {
        return accountDAOImpl.updateById(id, newAccount);
    }

    @Override
    public boolean deleteById(Integer id) {
        return accountDAOImpl.deleteById(id);
    }
}
