package ru.nsu.kurgin.lab5.chat.server;

import ru.nsu.kurgin.lab5.chat.Command.Massage;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    //    public static final int PORT = 11111;
    public static List<Communicator> serverList = new ArrayList<>();
    //    public static List<CommunicatorSerialization> serverListForSerilization = new ArrayList<>();
    public static List<Massage> messageList = new ArrayList<>();
    public static String typeConnect;

    public static void main(String[] args) throws IOException {
        System.out.println("write IP");
        Scanner in = new Scanner(System.in);
        String IP = in.nextLine();
        System.out.println("write port");
        String port = in.nextLine();
        InetAddress address = InetAddress.getByName(IP);
        ServerSocket server = new ServerSocket(/*Integer.parseInt(port)*/11111, 100, address);
        System.out.println("Write s - if Serialization and write j - if json");
        typeConnect = in.nextLine();
//        System.out.println(typeConnect);
        try {
            while (true) {
                Socket socket = server.accept();
                try {
//                    if (typeConnect.equals("j")) {
//                        System.out.println("norm");
                        serverList.add(new СommunicatorForClients(socket, new CommandExecutor()));
//                    } else if (typeConnect.equals("s")) {
//                        System.out.println("KAK tak");
//                        serverList.add(new CommunicatorSerialization(socket, new CommandExecutor()));
//                    }
//                        System.out.println("aaa");
                } catch (IOException e) {
                    socket.close();
                }
            }
        } finally {
            server.close();
        }
    }

    public static void delMember(Communicator communicatorDell) {
        serverList.remove(communicatorDell);
    }

    public static void addMessage(Massage msg) {
        if (messageList.toArray().length != Constants.BUFFER_SIZE) {
            messageList.add(msg);
        }
        if (messageList.toArray().length == Constants.BUFFER_SIZE) {
            messageList.remove(0);
            messageList.add(msg);
        }
    }
}