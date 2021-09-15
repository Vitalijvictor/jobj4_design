package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
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
            String line = bufferedReader.readLine();
            for (int i = 0; i < line.length(); i++) {
                line = String.valueOf(line.charAt(i));
                if (!(line == null)
                        || line.contains("#")
                        || line.contains(" ")) {
                    String[] keyValue = line.split("=");
                    if (keyValue.length != 2) {
                        throw new IllegalArgumentException("There must be at least 2 "
                                + "elements");
                    }
                    values.put(keyValue[0], keyValue[1]);
                }
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