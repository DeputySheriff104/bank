package ru.kolesnikov.bank.database;

public interface Data<Entity, Key> {
    Entity create(Entity model);
    Entity[] getAll();
    Entity getById(Key key);
    Entity updateById(Key key, Entity model);
    Entity deleteById(Key key);
}
