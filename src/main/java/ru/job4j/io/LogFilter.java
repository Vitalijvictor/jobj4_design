package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 0.3. BufferedReader. [#252489 #202008]
 */
public class LogFilter {
    public static List<String> filter(String file) throws IOException {
        List<String> list = new ArrayList<>(Collections.emptyList());
        try (BufferedReader text  = new BufferedReader(new FileReader(file))) {
            list = text
                    .lines()
                    .filter(s -> s.contains("404"))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            out.println(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> log = filter("log.txt");
        System.out.println(log);
        save(log, "404.txt");
    }
}

