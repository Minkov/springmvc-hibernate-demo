package com.minkov.springbootdemo.parsers;

public interface Parser<T> {
    String toString(Object object);
    T fromString(String str);
    T[] fromListString(String str);
}
