package ru.job4j.io;

import java.io.*;


public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(source));
            PrintWriter printWriter =
                    new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
                String serverDown = null;
                while (bufferedReader.ready()) {
                    String serverStatus = bufferedReader.readLine();
                    if (serverDown == null && serverStatus.startsWith("400")
                            || serverStatus.startsWith("500")) {
                        printWriter.println(serverStatus.split(" ")[1]
                                + "The" + " server is down");
                        serverDown = serverStatus;
                    } else if (serverDown != null && !serverStatus.startsWith(
                            "400")
                            && !serverStatus.startsWith("500")) {
                            printWriter.println(serverStatus.split(" ")[1]
                                    + "server is up");
                            serverDown = null;
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