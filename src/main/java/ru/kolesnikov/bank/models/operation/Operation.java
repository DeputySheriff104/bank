package ru.kolesnikov.bank.models.operation;

import ru.kolesnikov.bank.models.Entity;

public abstract class Operation extends Entity {

    private int moneyAmount;
    private String date;

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
