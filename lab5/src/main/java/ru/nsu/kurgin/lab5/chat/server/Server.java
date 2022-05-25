package ru.nsu.kurgin.lab5.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static final int PORT = 11111;
    public static List<СommunicatorForClients> serverList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        try {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new СommunicatorForClients(socket, new CommandExecutor()));
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }

    public static void delMember(СommunicatorForClients communicatorDell) {
        serverList.remove(communicatorDell);
    }
}