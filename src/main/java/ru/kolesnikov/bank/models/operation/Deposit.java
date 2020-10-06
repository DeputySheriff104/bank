package ru.kolesnikov.bank.models.operation;

public class Deposit extends Operation {

    private int toAccountId;

    public Deposit() {
    }

    public Deposit(int toAccountId, int moneyAmount) {
        this.toAccountId = toAccountId;
        setMoneyAmount(moneyAmount);
    }

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }
}
