package ru.kolesnikov.bank.dao.entities.operation;

import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.dao.connection.ConnectionPools;
import ru.kolesnikov.bank.dao.mappers.TransferMapper;
import ru.kolesnikov.bank.dao.queries.TransferQueries;
import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.models.operation.Transfer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TransferDAOImpl implements DAO<Transfer, Integer> {

    @Override
    public boolean create(Transfer newTransfer) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    TransferQueries.CREATE);
            TransferMapper.mapModelToEntity(newTransfer, st);
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
    public List<Transfer> getAll() {
        try {
            List<Transfer> transfersList = new ArrayList<>();
            Connection connection = ConnectionPools.BANK_POOL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    TransferQueries.GET_ALL);
            while (rs.next()) {
                Transfer transfer = TransferMapper.mapEntityToModel(rs);
                transfersList.add(transfer);
            }
            rs.close();
            statement.close();
            ConnectionPools.BANK_POOL.releaseConnection(connection);
            return transfersList;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return null;
        }
    }

    @Override
    public Transfer getById(Integer id) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    TransferQueries.GET_BY_ID);
            st.setInt("id", id);
            ResultSet rs = st.executeQuery();
            rs.next();
            Transfer transfer = TransferMapper.mapEntityToModel(rs);
            st.close();
            ConnectionPools.BANK_POOL.releaseConnection(conn);
            return transfer;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateById(Integer id, Transfer newTransfer) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    TransferQueries.UPDATE_BY_ID);
            TransferMapper.mapModelToEntity(newTransfer, st);
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
                    TransferQueries.DELETE_BY_ID);
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
