package ru.kolesnikov.bank.dao.queries;

public class TransferQueries {

    public static final String CREATE =
            "INSERT INTO transfers " +
                    "(from_account_id, to_account_id, money_amount) VALUES " +
                    "(:fromAccountId, :toAccountId, :moneyAmount);";

    public static final String GET_ALL =
            "SELECT * FROM transfers;";

    public static final String GET_BY_ID =
            "SELECT * FROM transfers " +
                    "WHERE id = :id;";

    public static final String UPDATE_BY_ID =
            "UPDATE transfers SET " +
                    "from_account_id = :fromAccountId, " +
                    "to_account_id = :toAccountId, " +
                    "money_amount = :moneyAmount, " +
                    "WHERE id = :id;";

    public static final String DELETE_BY_ID =
            "DELETE FROM transfers " +
                    "WHERE id = :id;";
}
