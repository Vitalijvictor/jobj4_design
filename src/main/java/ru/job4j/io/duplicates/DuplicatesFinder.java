package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Path path = Files.walkFileTree(Path.of("Files"), visitor);
        visitor.getPaths().entrySet().stream()
                .filter(f -> f.getValue().size() > 1)
                .collect(Collectors.toList())
                .forEach(f -> f.getValue().stream()
                        .forEach(System.out::println));
    }
}