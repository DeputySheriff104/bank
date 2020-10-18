package ru.kolesnikov.bank.models.account;

import ru.kolesnikov.bank.models.Entity;

public class Account extends Entity {

    private int userId;
    private String password;
    private int moneyAmount;

    public Account() {
    }

    public Account(int id, int userId, String password, int moneyAmount) {
        setId(id);
        this.userId = userId;
        this.password = password;
        this.moneyAmount = moneyAmount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
