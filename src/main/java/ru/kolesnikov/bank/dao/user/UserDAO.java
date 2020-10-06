package ru.kolesnikov.bank.dao.user;

import ru.kolesnikov.bank.dao.DAO;
import ru.kolesnikov.bank.database.user.UserData;
import ru.kolesnikov.bank.models.user.User;

public class UserDAO implements DAO<User, Integer> {

    public final UserData userData;

    public UserDAO(UserData userData) {
        this.userData = userData;
    }

    @Override
    public User create(User newUser) {
        return userData.create(newUser);
    }

    @Override
    public User[] getAll() {
        return userData.getAll();
    }

    @Override
    public User getById(Integer id) {
        return userData.getById(id);
    }

    @Override
    public User updateById(Integer id, User newUser) {
        return userData.updateById(id, newUser);
    }

    @Override
    public User deleteById(Integer id) {
        return userData.deleteById(id);
    }
}
