package ru.kolesnikov.bank.dao.mappers;

import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.models.user.User;

import java.sql.ResultSet;

public class AccountMapper {

    public static void mapModelToEntity(Account account, NamedParametersStatement st) {
        try {
            st.setString("password", account.getPassword());
            st.setInt("moneyAmount", account.getMoneyAmount());
            st.setInt("userId", account.getUserId());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static Account mapEntityToModel(ResultSet rs) {
        try {
            return new Account(
                    rs.getInt("id"),
                    rs.getInt("user_id"),
                    rs.getString("password"),
                    rs.getInt("money_amount"));
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
