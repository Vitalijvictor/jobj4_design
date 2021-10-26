package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

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
}
