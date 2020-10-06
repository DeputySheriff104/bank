package ru.kolesnikov.bank.database.user;

import ru.kolesnikov.bank.database.Data;
import ru.kolesnikov.bank.models.user.User;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserData implements Data<User, Integer> {

    private final Map<Integer, User> USERS;

    private final AtomicInteger lastId = new AtomicInteger(0);

    public UserData(Map<Integer, User> USERS) {
        this.USERS = USERS;
    }

    @Override
    public User create(User newUser) {
        int newId = lastId.incrementAndGet();
        newUser.setId(newId);
        USERS.put(newId, newUser);
        return newUser;
    }

    @Override
    public User[] getAll() {
        return USERS.values().toArray(new User[0]);
    }

    @Override
    public User getById(Integer id) {
        return USERS.get(id);
    }

    @Override
    public User updateById(Integer id, User newUser) {
        return USERS.replace(id, newUser);
    }

    @Override
    public User deleteById(Integer id) {
        return USERS.remove(id);
    }
}
