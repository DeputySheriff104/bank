package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.account.AccountDAO;
import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.services.AccountService;

public class AccountServiceImpl implements AccountService {

    private final AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account create(Account newAccount) {
        return accountDAO.create(newAccount);
    }

    @Override
    public Account[] getAll() {
        return accountDAO.getAll();
    }

    @Override
    public Account getById(Integer id) {
        return accountDAO.getById(id);
    }

    @Override
    public Account updateById(Integer id, Account newAccount) {
        return accountDAO.updateById(id, newAccount);
    }

    @Override
    public Account deleteById(Integer id) {
        return accountDAO.deleteById(id);
    }
}
