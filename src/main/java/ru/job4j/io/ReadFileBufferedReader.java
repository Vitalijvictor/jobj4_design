package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * В потоках ввода вывода для этого есть буферизированные обертки.
 *
 * Перепишем код через буферизированные потоки
 */
public class ReadFileBufferedReader {
    public static void main(String[] args) {
        try (BufferedReader in =
                     new BufferedReader(new FileReader("log.txt"))) {
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
