package com.minkov.app.repositories.base;

import java.util.List;

public interface DataRepository<T> {
    List<T> list();

    void add(T item);
}
