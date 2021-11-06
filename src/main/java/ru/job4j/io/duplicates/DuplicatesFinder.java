package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        List<Path> paths = visitor.duplicatesFinder();
        paths.stream().forEach(System.out::println);
    }
}