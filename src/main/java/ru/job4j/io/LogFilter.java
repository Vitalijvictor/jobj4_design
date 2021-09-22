package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) throws IOException {
        try (BufferedReader text  = new BufferedReader(new FileReader(file))) {
            text
                    .lines()
                    .filter(s -> s.contains("404"))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
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

