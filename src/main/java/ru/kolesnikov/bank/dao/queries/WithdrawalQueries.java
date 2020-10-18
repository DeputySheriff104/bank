package ru.kolesnikov.bank.dao.queries;

public class WithdrawalQueries {

    public static final String CREATE =
            "INSERT INTO withdrawals " +
                    "(from_account_id, money_amount) VALUES " +
                    "(:fromAccountId, :moneyAmount);";

    public static final String GET_ALL =
            "SELECT * FROM withdrawals;";

    public static final String GET_BY_ID =
            "SELECT * FROM withdrawals " +
                    "WHERE id = :id;";

    public static final String UPDATE_BY_ID =
            "UPDATE withdrawals SET " +
                    "from_account_id = :fromAccountId, " +
                    "money_amount = :moneyAmount, " +
                    "WHERE id = :id;";

    public static final String DELETE_BY_ID =
            "DELETE FROM withdrawals " +
                    "WHERE id = :id;";
}
