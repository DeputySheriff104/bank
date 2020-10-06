package ru.kolesnikov.bank.models.operation;

public class Withdrawal extends Operation {

    private int fromAccountId;

    public Withdrawal() {
    }

    public Withdrawal(int fromAccountId, int moneyAmount) {
        this.fromAccountId = fromAccountId;
        setMoneyAmount(moneyAmount);
    }

    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
}
