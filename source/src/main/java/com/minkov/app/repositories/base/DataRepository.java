package com.minkov.app.repositories.base;

import java.util.List;

public interface DataRepository<T> {
    List<T> listAll();

    T find(long id);

    void add(T item);

    void update(T entity);

    void update(long id, T entity);

    void delete(T entity);

    void delete(long id);
}
