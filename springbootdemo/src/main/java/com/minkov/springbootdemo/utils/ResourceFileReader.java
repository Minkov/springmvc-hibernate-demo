package com.minkov.springbootdemo.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ResourceFileReader {
    String readResourceFile(String fileName) throws IOException;
}
