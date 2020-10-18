package ru.kolesnikov.bank.dao.queries;

public class DepositQueries {

    public static final String CREATE =
            "INSERT INTO deposits " +
                    "(to_account_id, money_amount) VALUES " +
                    "(:toAccountId, :moneyAmount);";

    public static final String GET_ALL =
            "SELECT * FROM deposits;";

    public static final String GET_BY_ID =
            "SELECT * FROM deposits " +
                    "WHERE id = :id;";

    public static final String UPDATE_BY_ID =
            "UPDATE deposits SET " +
                    "to_account_id = :toAccountId, " +
                    "money_amount = :moneyAmount, " +
                    "WHERE id = :id;";

    public static final String DELETE_BY_ID =
            "DELETE FROM deposits " +
                    "WHERE id = :id;";
}
