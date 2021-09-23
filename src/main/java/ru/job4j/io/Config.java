package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(this.path))) {
            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            for (String line : lines) {
                if (line.startsWith("#") || line.startsWith(" ")) {
                    continue;
                }
                String[] keyValue = line.split("=");
                if (keyValue.length != 2) {
                    throw new IllegalArgumentException("There must be at least 2 "
                            + "elements: " + line);
                }
                values.put(keyValue[0], keyValue[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }

}