package ru.kolesnikov.bank.dao.account;

import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.database.account.AccountData;
import ru.kolesnikov.bank.models.account.Account;

public class AccountDAO implements DAO<Account, Integer> {

    public final AccountData accountData;

    public AccountDAO(AccountData accountData) {
        this.accountData = accountData;
    }

    @Override
    public Account create(Account newAccount) {
        return accountData.create(newAccount);
    }

    @Override
    public Account[] getAll() {
        return accountData.getAll();
    }

    @Override
    public Account getById(Integer id) {
        return accountData.getById(id);
    }

    @Override
    public Account updateById(Integer id, Account newAccount) {
        return accountData.updateById(id, newAccount);
    }

    @Override
    public Account deleteById(Integer id) {
        return accountData.deleteById(id);
    }
}
