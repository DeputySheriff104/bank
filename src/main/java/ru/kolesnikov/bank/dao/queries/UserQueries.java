package ru.kolesnikov.bank.dao.queries;

public class UserQueries {

    public static final String CREATE =
            "INSERT INTO users " +
                    "(login, password, first_name, last_name, phone, email) VALUES " +
                    "(:login, :password, :firstName, :lastName, :phone, :email);";

    public static final String GET_ALL =
            "SELECT * FROM users;";

    public static final String GET_BY_ID =
            "SELECT * FROM users " +
                    "WHERE id = :id;";

    public static final String UPDATE_BY_ID =
            "UPDATE users SET " +
                    "login = :login, " +
                    "password = :password, " +
                    "first_name = :firstName, " +
                    "last_name = :lastName, " +
                    "phone = :phone, " +
                    "email = :email " +
                    "WHERE id = :id;";

    public static final String DELETE_BY_ID =
            "DELETE FROM users " +
                    "WHERE id = :id;";
}

