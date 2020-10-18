package ru.kolesnikov.bank.dao.mappers;

import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.operation.Transfer;
import ru.kolesnikov.bank.models.operation.Withdrawal;

import java.sql.ResultSet;

public class TransferMapper {

    public static void mapModelToEntity(Transfer transfer, NamedParametersStatement st) {
        try {
            st.setInt("fromAccountId", transfer.getFromAccountId());
            st.setInt("toAccountId", transfer.getToAccountId());
            st.setInt("moneyAmount", transfer.getMoneyAmount());
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static Transfer mapEntityToModel(ResultSet rs) {
        try {
            return new Transfer(
                    rs.getInt("id"),
                    rs.getInt("from_account_id"),
                    rs.getInt("to_account_id"),
                    rs.getInt("money_amount"),
                    rs.getString("date"));
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }
}
