package ru.job4j.io.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final Socket clientSocket;

    public Server(Socket socket) {
        this.clientSocket = socket;
    }


    public void startServer() {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String ask;
            do {
                System.out.println("wait command ...");
                ask = in.readLine();
                System.out.println(ask);
                if ("hello oracle".equalsIgnoreCase(ask)
                        || "hi".equalsIgnoreCase(ask)
                        || "hello".equalsIgnoreCase(ask)) {
                    out.println("Hello, dear friend, I'm a oracle.");
                    out.println();
                } else if ("bye".equalsIgnoreCase(ask) || "See you".equalsIgnoreCase(ask)
                        || "goodBye".equalsIgnoreCase(ask)) {
                    out.println("GoodBye, my friend!");
                    out.println();
                } else {
                    out.println("What did you mean?");
                    out.println();
                }
            } while (!("bye".equalsIgnoreCase(ask) || "See you".equalsIgnoreCase(ask)
                    || "goodBye".equalsIgnoreCase(ask)));
        } catch (IOException exc) {
            exc.printStackTrace();
        }


    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(8000).accept()) {
            new Server(socket).startServer();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
