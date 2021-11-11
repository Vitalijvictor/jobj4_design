package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<File> sources, File target) throws IOException {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File s : sources) {
                zip.putNextEntry(new ZipEntry(s.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(s))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgsName cmd = ArgsName.of(args);
        Path dir = null;
        String ext = null;
        Path out = null;
        try {
            dir = Paths.get(cmd.get("d"));
        } catch (IllegalArgumentException e) {
            dir = null;
        }

        try {
            ext = cmd.get("e");
        } catch (IllegalArgumentException e) {
            ext = null;
        }

        try {
            out = Paths.get(cmd.get("o"));
        } catch (IllegalArgumentException e) {
            out = null;
        }

        if (dir != null && ext != null && out != null) {
            File sourceDir = new File(String.valueOf(dir));
            if (sourceDir.isDirectory()) {
                final String extensionString = ext;
                try {
                    List<Path> paths = Search.search(dir,
                            p -> !p.toFile().getName().endsWith(extensionString));
                    List<File> files = paths.stream()
                            .map(p -> p.toFile()).collect(Collectors.toList());

                    packFiles(files, out.toFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}