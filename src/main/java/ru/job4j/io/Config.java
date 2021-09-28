package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(this.path))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                if (line.equals(" ")) {
                    continue;
                }
                if (line.startsWith("#")) {
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