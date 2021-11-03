package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    Map<FileProperty, List<Path>> paths = new HashMap<>();
    public Map<FileProperty, List<Path>> getPaths() {
        return paths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(),
                file.getFileName().toString());

        if (!paths.containsKey(fileProperty)) {
            List<Path> duplicates = new ArrayList<>();
            duplicates.add(file);
            paths.put(fileProperty, duplicates);
        } else {
            List<Path> duplicates = paths.get(fileProperty);
            duplicates.add(file);
        }
        return super.visitFile(file, attrs);
    }

    public DuplicatesVisitor duplicatesFinder(DuplicatesVisitor visitor) throws IOException {
        Path path = Files.walkFileTree(Path.of("Files"),
                visitor);
        visitor.getPaths().entrySet().stream()
                .filter(f -> f.getValue().size() > 1)
                .collect(Collectors.toList())
                .forEach(f -> f.getValue().stream()
                        .forEach(System.out::println));
        return visitor;
    }
}
