package com.minkov.springbootdemo.parsers.implementations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.minkov.springbootdemo.parsers.Parser;
import org.springframework.stereotype.Component;

@Component
public class GsonParser implements Parser {
    static Gson gson;

    static {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public String toString(Object obj) {
        return gson.toJson(obj);
    }

    @Override
    public <T> T fromString(String str, Class<T> klass) {
        return gson.fromJson(str, klass);
    }
}
