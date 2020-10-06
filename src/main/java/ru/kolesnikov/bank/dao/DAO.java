package ru.kolesnikov.bank.dao;

public interface DAO<Entity, Key> {
    Entity create(Entity model);
    Entity[] getAll();
    Entity getById(Key key);
    Entity updateById(Key key, Entity model);
    Entity deleteById(Key key);
}
