package ru.kolesnikov.bank.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<Entity, Key> {

    boolean create(Entity model);
    List<Entity> getAll() throws SQLException;
    Entity getById(Key key);
    boolean updateById(Key key, Entity model);
    boolean deleteById(Key key);
}
