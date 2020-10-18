package ru.kolesnikov.bank.dao.entities.operation;

import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.dao.connection.ConnectionPools;
import ru.kolesnikov.bank.dao.mappers.WithdrawalMapper;
import ru.kolesnikov.bank.dao.queries.WithdrawalQueries;
import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.models.operation.Withdrawal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WithdrawalDAOImpl implements DAO<Withdrawal, Integer> {

    @Override
    public boolean create(Withdrawal newWithdrawal) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    WithdrawalQueries.CREATE);
            WithdrawalMapper.mapModelToEntity(newWithdrawal, st);
            st.executeUpdate();
            st.close();
            ConnectionPools.BANK_POOL.releaseConnection(conn);
            return true;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
    }

    @Override
    public List<Withdrawal> getAll() {
        try {
            List<Withdrawal> withdrawalsList = new ArrayList<>();
            Connection connection = ConnectionPools.BANK_POOL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    WithdrawalQueries.GET_ALL);
            while (rs.next()) {
                Withdrawal withdrawal = WithdrawalMapper.mapEntityToModel(rs);
                withdrawalsList.add(withdrawal);
            }
            rs.close();
            statement.close();
            ConnectionPools.BANK_POOL.releaseConnection(connection);
            return withdrawalsList;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return null;
        }
    }

    @Override
    public Withdrawal getById(Integer id) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    WithdrawalQueries.GET_BY_ID);
            st.setInt("id", id);
            ResultSet rs = st.executeQuery();
            rs.next();
            Withdrawal withdrawal = WithdrawalMapper.mapEntityToModel(rs);
            st.close();
            ConnectionPools.BANK_POOL.releaseConnection(conn);
            return withdrawal;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateById(Integer id, Withdrawal newWithdrawal) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    WithdrawalQueries.UPDATE_BY_ID);
            WithdrawalMapper.mapModelToEntity(newWithdrawal, st);
            st.setInt("id", id);
            st.executeUpdate();
            st.close();
            ConnectionPools.BANK_POOL.releaseConnection(conn);
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    WithdrawalQueries.DELETE_BY_ID);
            st.setObject("id", id);
            st.executeQuery();
            st.close();
            ConnectionPools.BANK_POOL.releaseConnection(conn);
            return true;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }
}
