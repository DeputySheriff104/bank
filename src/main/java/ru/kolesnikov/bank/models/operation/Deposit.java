package ru.kolesnikov.bank.models.operation;

public class Deposit extends Operation {

    private int toAccountId;

    public Deposit() {
    }

    public Deposit(int id, int toAccountId, int moneyAmount, String date) {
        setId(id);
        this.toAccountId = toAccountId;
        setMoneyAmount(moneyAmount);
        setDate(date);
    }

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }
}
