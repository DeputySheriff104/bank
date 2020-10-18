package ru.kolesnikov.bank.dao.entities.account;

import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.dao.connection.ConnectionPools;
import ru.kolesnikov.bank.dao.mappers.AccountMapper;
import ru.kolesnikov.bank.dao.queries.AccountQueries;
import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.account.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements DAO<Account, Integer> {

    @Override
    public boolean create(Account newAccount) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    AccountQueries.CREATE);
            AccountMapper.mapModelToEntity(newAccount, st);
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
    public List<Account> getAll() {
        try {
            List<Account> accountsList = new ArrayList<>();
            Connection connection = ConnectionPools.BANK_POOL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    AccountQueries.GET_ALL);
            while (rs.next()) {
                Account account = AccountMapper.mapEntityToModel(rs);
                accountsList.add(account);
            }
            rs.close();
            statement.close();
            ConnectionPools.BANK_POOL.releaseConnection(connection);
            return accountsList;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return null;
        }
    }

    @Override
    public Account getById(Integer id) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    AccountQueries.GET_BY_ID);
            st.setInt("id", id);
            ResultSet rs = st.executeQuery();
            rs.next();
            Account account = AccountMapper.mapEntityToModel(rs);
            st.close();
            ConnectionPools.BANK_POOL.releaseConnection(conn);
            return account;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateById(Integer id, Account newAccount) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    AccountQueries.UPDATE_BY_ID);
            AccountMapper.mapModelToEntity(newAccount, st);
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
                    AccountQueries.DELETE_BY_ID);
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
