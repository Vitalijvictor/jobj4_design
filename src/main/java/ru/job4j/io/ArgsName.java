package ru.job4j.io;

import java.util.*;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String string : args) {
            if (!string.contains("-") || !string.contains("=")) {
                throw new IllegalArgumentException();
            }
            String[] rsl = string.split("=");
            if (rsl.length != 2) {
                throw new IllegalArgumentException();
            }
            for (String s : rsl) {
                if (s.isEmpty()) {
                    throw new IllegalArgumentException();
                }
            }
            values.put(rsl[0].replace("-", ""), rsl[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));
        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}