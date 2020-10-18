package ru.kolesnikov.bank.models.operation;

public class Withdrawal extends Operation {

    private int fromAccountId;

    public Withdrawal() {
    }

    public Withdrawal(int id, int fromAccountId, int moneyAmount, String date) {
        setId(id);
        this.fromAccountId = fromAccountId;
        setMoneyAmount(moneyAmount);
        setDate(date);
    }

    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
}
