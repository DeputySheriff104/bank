package ru.kolesnikov.bank.services.impl;

import ru.kolesnikov.bank.dao.user.UserDAO;
import ru.kolesnikov.bank.models.user.User;
import ru.kolesnikov.bank.services.UserService;

public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User create(User newUser) {
        return userDAO.create(newUser);
    }

    @Override
    public User[] getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userDAO.getById(id);
    }

    @Override
    public User updateById(Integer id, User newUser) {
        return userDAO.updateById(id, newUser);
    }

    @Override
    public User deleteById(Integer id) {
        return userDAO.deleteById(id);
    }
}
