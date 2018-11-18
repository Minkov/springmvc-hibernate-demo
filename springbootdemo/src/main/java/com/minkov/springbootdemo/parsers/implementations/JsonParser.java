package com.minkov.springbootdemo.parsers.implementations;

import com.google.gson.Gson;
import com.minkov.springbootdemo.parsers.Parser;

public class JsonParser<T> implements Parser<T> {
    private final Class<T> klass;
    private final Class<T[]> klassArray;
    private final Gson gson;

    public JsonParser(Class<T> klass, Class<T[]> klassArray) {
        this.klass = klass;
        this.klassArray = klassArray;
        this.gson = new Gson();
    }
    @Override
    public String toString(Object object) {
        return gson.toJson(object);
    }

    @Override
    public T fromString(String str) {
        return gson.fromJson(str, klass);
    }

    @Override
    public T[] fromListString(String str) {
        return gson.fromJson(str, klassArray);
    }
}
