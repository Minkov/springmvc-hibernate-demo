package com.minkov.springbootdemo.parsers;

public interface Parser {
    String toString(Object obj);
    <T> T fromString(String str, Class<T> klass);
}
