package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Класс java.io.FileOutputStream позволяет записать данные в файл.
 * 1. Конструктор класса FileOutputStream принимает имя файла.
 * Файл будет создан в корне проекта.
 *
 * 2. Для записи используется метод out.write. Этот метод принимает массив байт,
 * поэтому строку преобразовали в массив байтов.
 *
 * 3. Любой ресурс должен быть закрыт для это используется конструкция try-with-resources.
 */
public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    String rsl = String.valueOf(Integer.valueOf(i * j));
                    out.write(rsl.getBytes()); // то что будет записываться в
                    // файл
                }
                    out.write(System.lineSeparator().getBytes());
                //разделение строк
                }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
