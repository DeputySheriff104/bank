package ru.kolesnikov.bank.dao.entities.user;

import ru.kolesnikov.bank.dao.connection.ConnectionPools;
import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.dao.mappers.UserMapper;
import ru.kolesnikov.bank.dao.queries.UserQueries;
import ru.kolesnikov.bank.dao.utils.NamedParametersStatement;
import ru.kolesnikov.bank.models.account.Account;
import ru.kolesnikov.bank.models.user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements DAO<User, Integer> {

    @Override
    public boolean create(User newUser) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    UserQueries.CREATE);
            UserMapper.mapModelToEntity(newUser, st);
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
    public List<User> getAll() {
        try {
            List<User> usersList = new ArrayList<>();
            Connection connection = ConnectionPools.BANK_POOL.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    UserQueries.GET_ALL);
            while (rs.next()) {
                User user = UserMapper.mapEntityToModel(rs);
                usersList.add(user);
            }
            rs.close();
            statement.close();
            ConnectionPools.BANK_POOL.releaseConnection(connection);
            return usersList;
        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return null;
        }
    }

    @Override
    public User getById(Integer id) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    UserQueries.GET_BY_ID);
            st.setInt("id", id);
            ResultSet rs = st.executeQuery();
            rs.next();
            User user = UserMapper.mapEntityToModel(rs);
            st.close();
            ConnectionPools.BANK_POOL.releaseConnection(conn);
            return user;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }
    }

    @Override
    public boolean updateById(Integer id, User newUser) {
        try {
            Connection conn = ConnectionPools.BANK_POOL.getConnection();
            NamedParametersStatement st = new NamedParametersStatement(conn,
                    UserQueries.UPDATE_BY_ID);
            UserMapper.mapModelToEntity(newUser, st);
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
                    UserQueries.DELETE_BY_ID);
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
