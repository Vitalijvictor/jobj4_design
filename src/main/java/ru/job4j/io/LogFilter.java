package ru.job4j.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) throws FileNotFoundException {
        List<String> text = Collections.singletonList(new String(String.valueOf(new FileReader(file))));
        text.stream()
                .filter(s -> s.contains("404"))
                .collect(Collectors.toList());
        return text;
    }

    public static void main(String[] args) throws FileNotFoundException {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
