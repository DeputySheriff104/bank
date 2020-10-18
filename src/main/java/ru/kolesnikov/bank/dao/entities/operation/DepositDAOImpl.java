package ru.kolesnikov.bank.dao.entities.operation;

import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.dao.connection.ConnectionPools;
import ru.kolesnikov.bank.dao.mappers.DepositMapper;
import ru.kolesnikov.bank.dao.queries.DepositQueries;
import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.models.operation.Deposit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepositDAOImpl implements DAO<Deposit, Integer> {

    @Override
    public boolean create(Deposit newDeposit) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    DepositQueries.CREATE);
            DepositMapper.mapModelToEntity(newDeposit, st);
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
    public List<Deposit> getAll() {
        try {
            List<Deposit> depositsList = new ArrayList<>();
            Connection connection = ConnectionPools.BANK_POOL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    DepositQueries.GET_ALL);
            while (rs.next()) {
                Deposit deposit = DepositMapper.mapEntityToModel(rs);
                depositsList.add(deposit);
            }
            rs.close();
            statement.close();
            ConnectionPools.BANK_POOL.releaseConnection(connection);
            return depositsList;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return null;
        }
    }

    @Override
    public Deposit getById(Integer id) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    DepositQueries.GET_BY_ID);
            st.setInt("id", id);
            ResultSet rs = st.executeQuery();
            rs.next();
            Deposit deposit = DepositMapper.mapEntityToModel(rs);
            st.close();
            ConnectionPools.BANK_POOL.releaseConnection(conn);
            return deposit;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateById(Integer id, Deposit newDeposit) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    DepositQueries.UPDATE_BY_ID);
            DepositMapper.mapModelToEntity(newDeposit, st);
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
                    DepositQueries.DELETE_BY_ID);
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
