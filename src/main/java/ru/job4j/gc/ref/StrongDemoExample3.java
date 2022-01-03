package ru.job4j.gc.ref;

import java.util.ArrayList;
import java.util.List;

public class StrongDemoExample3 {

    public static void main(String[] args) throws InterruptedException {
        example3();
    }

    private static void example3() {
        List<String> strings = new ArrayList<>();
        while (true) {
            strings.add(String.valueOf(System.currentTimeMillis()));
        }
    }
}