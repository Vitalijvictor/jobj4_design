package ru.job4j.io;
/**
 * Этот класс позволяет прочитать данные из файла.
 */

import java.io.FileInputStream;

/**
 * Читаем текст из файла
 */
public class ReadFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("log.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            System.out.println(text);

            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(line + " Текс разбитый построчно");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}