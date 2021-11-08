package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("C:\\projects\\job4j_design\\Files"), visitor);
        List<Path> paths = visitor.duplicatesFinder();
        paths.stream().forEach(System.out::println);
    }
}