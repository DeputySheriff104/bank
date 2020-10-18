package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.entities.user.UserDAOImpl;
import ru.kolesnikov.bank.models.user.User;
import ru.kolesnikov.bank.services.Service;

import java.util.List;

public class UserServiceImpl implements Service<User, Integer> {
    private final UserDAOImpl userDAOImpl;

    public UserServiceImpl(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    @Override
    public boolean create(User newUser) {
        return userDAOImpl.create(newUser);
    }

    @Override
    public List<User> getAll() {
        return userDAOImpl.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userDAOImpl.getById(id);
    }

    @Override
    public boolean updateById(Integer id, User newUser) {
        return userDAOImpl.updateById(id, newUser);
    }

    @Override
    public boolean deleteById(Integer id) {
        return userDAOImpl.deleteById(id);
    }
}
