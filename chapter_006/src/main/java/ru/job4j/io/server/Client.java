package ru.job4j.io.server;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void startClient() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {
            String str = "";
            String ans;
            do {
                out.println(console.readLine());
                while (!(ans = in.readLine()).isEmpty()) {
                    str = ans;
                    System.out.println(str);
                }
            } while (!"GoodBye, my friend!".equals(str));
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8000)) {
            new Client(socket).startClient();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
