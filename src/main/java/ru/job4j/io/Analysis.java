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
                    if (!serverDown  && (serverStatus.startsWith("400"))
                            || serverStatus.startsWith("500")) {
                        printWriter.println(serverStatus.split(" ")[1]
                                + ";");
                        serverDown = Boolean.valueOf(serverStatus);
                    } else if (serverDown && (!serverStatus.startsWith(
                            "400"))
                            && !serverStatus.startsWith("500")) {
                            printWriter.println(serverStatus.split(" ")[1]
                                    + ";");
                            serverDown = Boolean.parseBoolean(null);
                        }
                    }
                } catch (IOException e) {
            e.printStackTrace();
        }
            }


    public static void main(String[] args) {
//        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
//            out.println("15:01:30;15:02:32");
//            out.println("15:10:30;23:12:32");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Analysis analysis = new Analysis();
        analysis.unavailable("./data/server.log", "unavailable.csv");

    }
}