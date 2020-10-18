package ru.kolesnikov.bank.dao.mappers;

import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.models.operation.Deposit;

import java.sql.ResultSet;

public class DepositMapper {

    public static void mapModelToEntity(Deposit deposit, NamedParametersStatement st) {
        try {
            st.setInt("toAccountId", deposit.getToAccountId());
            st.setInt("moneyAmount", deposit.getMoneyAmount());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static Deposit mapEntityToModel(ResultSet rs) {
        try {
            return new Deposit(
                    rs.getInt("id"),
                    rs.getInt("to_account_id"),
                    rs.getInt("money_amount"),
                    rs.getString("date"));
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
