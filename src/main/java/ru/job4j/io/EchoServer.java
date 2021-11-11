package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
    public static void main(String[] args) {
        final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (str.contains("msg=Hello")) {
                            System.out.println("Hello");
                        }
                        if (str.contains("msg=Any")) {
                            System.out.println("What");
                        }
                        if (str.contains("msg=Exit")) {
                            System.out.println("Завершить работу сервера.");
                            server.close();
                        }
                    }
                    out.flush();
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
