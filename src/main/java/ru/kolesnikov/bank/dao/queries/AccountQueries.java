package ru.kolesnikov.bank.dao.queries;

public class AccountQueries {

    public static final String CREATE =
            "INSERT INTO accounts " +
                    "(user_id, password, money_amount) VALUES " +
                    "(:userId, :password, :moneyAmount);";

    public static final String GET_ALL =
            "SELECT * FROM accounts;";

    public static final String GET_BY_ID =
            "SELECT * FROM accounts " +
                    "WHERE id = :id;";

    public static final String UPDATE_BY_ID =
            "UPDATE accounts SET " +
                    "user_id = :userId, " +
                    "password = :password, " +
                    "money_amount = :moneyAmount, " +
                    "WHERE id = :id;";

    public static final String DELETE_BY_ID =
            "DELETE FROM accounts " +
                    "WHERE id = :id;";
}
