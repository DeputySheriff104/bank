package ru.kolesnikov.bank.dao.mappers;

import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.operation.Deposit;
import ru.kolesnikov.bank.models.operation.Withdrawal;

import java.sql.ResultSet;

public class WithdrawalMapper {

    public static void mapModelToEntity(Withdrawal withdrawal, NamedParametersStatement st) {
        try {
            st.setInt("fromAccountId", withdrawal.getFromAccountId());
            st.setInt("moneyAmount", withdrawal.getMoneyAmount());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static Withdrawal mapEntityToModel(ResultSet rs) {
        try {
            return new Withdrawal(
                    rs.getInt("id"),
                    rs.getInt("from_account_id"),
                    rs.getInt("money_amount"),
                    rs.getString("date"));
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
