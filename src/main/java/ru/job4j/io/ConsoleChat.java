package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> logs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean isOuted = false;
        boolean isStopped = false;
        List<String> phrases = readPhrases();
        while (!isOuted) {
            String string = scanner.next();
            logs.add(string);
            switch (string) {
                case OUT:
                    isOuted = true;
                    break;
                case STOP:
                    isStopped = true;
                    break;
                case CONTINUE:
                    isStopped = false;
                    break;
                default:
                    if (!isStopped) {
                        int phraseId = (int) (Math.random() * phrases.size());
                        String randomPhrase = phrases.get(phraseId);
                        System.out.println(randomPhrase);
                        logs.add(randomPhrase);
                    }
            }
        }
        saveLog(logs);
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("C:\\projects\\job4j_design\\logX.txt", "C:\\projects\\job4j_design\\phrases.txt");
        cc.run();
    }
}