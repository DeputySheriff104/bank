package ru.kolesnikov.bank.database.account;

import ru.kolesnikov.bank.database.Data;
import ru.kolesnikov.bank.models.account.Account;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountData implements Data<Account, Integer> {

    private final Map<Integer, Account> ACCOUNTS;

    private final AtomicInteger lastId = new AtomicInteger(0);

    public AccountData(Map<Integer, Account> ACCOUNTS) {
        this.ACCOUNTS = ACCOUNTS;
    }

    @Override
    public Account create(Account newAccount) {
        int newId = lastId.incrementAndGet();
        newAccount.setId(newId);
        ACCOUNTS.put(newId, newAccount);
        return newAccount;
    }

    @Override
    public Account[] getAll() {
        return ACCOUNTS.values().toArray(new Account[0]);
    }

    @Override
    public Account getById(Integer id) {
        return ACCOUNTS.get(id);
    }

    @Override
    public Account updateById(Integer id, Account newAccount) {
        return ACCOUNTS.replace(id, newAccount);
    }

    @Override
    public Account deleteById(Integer id) {
        return ACCOUNTS.remove(id);
    }
}
