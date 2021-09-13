package ru.job4j.io;

import java.io.FileInputStream;

/**
 * В классе нужно прочитать файл even.txt.
 * Для каждого числа проверить является ли оно четным числом.
 * Ответ вывести на консоль.
 */
public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                int numbers = Integer.parseInt(line);
                if (numbers % 2 == 0) {
                    System.out.println(line + " Even number");
                } else {
                    System.out.println(line + " Not even number");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}