package ru.kolesnikov.bank.models.operation;

public class Transfer extends Operation {

    private int fromAccountId;
    private int toAccountId;

    public Transfer() {
    }

    public Transfer(int id, int fromAccountId, int toAccountId, int moneyAmount, String date) {
        setId(id);
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        setMoneyAmount(moneyAmount);
        setDate(date);
    }

    public int getFromAccountId() {
        return fromAccountId;
    }

    public void setFromAccountId(int fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    public int getToAccountId() {
        return toAccountId;
    }

    public void setToAccountId(int toAccountId) {
        this.toAccountId = toAccountId;
    }
}
