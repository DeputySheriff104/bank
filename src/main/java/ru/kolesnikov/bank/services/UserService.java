package ru.kolesnikov.bank.services;

import ru.kolesnikov.bank.models.user.User;

public interface UserService {
    User create(User newUser);
    User[] getAll();
    User getById(Integer id);
    User updateById(Integer id, User newUser);
    User deleteById(Integer id);
}
