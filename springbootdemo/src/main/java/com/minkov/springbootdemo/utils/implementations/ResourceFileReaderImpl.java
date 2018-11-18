package com.minkov.springbootdemo.utils.implementations;

import com.minkov.springbootdemo.utils.ResourceFileReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

@Component
public class ResourceFileReaderImpl implements ResourceFileReader {
    @Override
    public String readResourceFile(String fileName) throws IOException {
        File file = new ClassPathResource(fileName)
                .getFile();
        StringBuilder builder = new StringBuilder();
        var reader = new Scanner(new FileReader(file));
        while (reader.hasNext()) {
            builder.append(reader.next());
            builder.append("\n");
        }

        return builder.toString();
    }
}
