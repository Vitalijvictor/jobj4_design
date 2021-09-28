package ru.job4j.io;

import java.io.*;


public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(source));
            PrintWriter printWriter =
                    new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
                boolean serverDown = false;
                while (bufferedReader.ready()) {
                    String serverStatus = bufferedReader.readLine();
                    if (!serverDown && (serverStatus.startsWith("400"))
                            || serverStatus.startsWith("500")) {
                        printWriter.print(serverStatus.split(" ")[1] + ";");
                        serverDown = true;
                    } else if (serverDown && (!serverStatus.startsWith(
                            "400"))
                            && !serverStatus.startsWith("500")) {
                        printWriter.println(serverStatus.split(" ")[1] + ";");
                        serverDown = false;
                    }
                    }
                } catch (IOException e) {
            e.printStackTrace();
        }
            }


    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("./data/server.log", "unavailable.csv");

    }
}