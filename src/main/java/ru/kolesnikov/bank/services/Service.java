package ru.kolesnikov.bank.services;

import java.sql.SQLException;
import java.util.List;

public interface Service<Entity, Key> {

    boolean create(Entity model);
    List<Entity> getAll() throws SQLException;
    Entity getById(Key key);
    boolean updateById(Key key, Entity model);
    boolean deleteById(Key key);
}
