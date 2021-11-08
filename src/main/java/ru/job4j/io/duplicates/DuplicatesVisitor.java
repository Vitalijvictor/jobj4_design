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
        FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());

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

    public List<Path> duplicatesFinder() throws IOException {
//        Files.walkFileTree(Path.of("C:\\projects\\job4j_design\\Files"), this);
        List<Map.Entry<FileProperty, List<Path>>> entries = this.getPaths().entrySet().stream()
                .filter(f -> f.getValue().size() > 1).collect(Collectors.toList());

        List<Path> paths = entries.stream().flatMap(f -> f.getValue().stream()).collect(Collectors.toList());
        return paths;
    }
}
